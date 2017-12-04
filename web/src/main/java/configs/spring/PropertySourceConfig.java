package configs.spring;

import com.spring.utility.message.CodeMessageAccessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.util.Locale;
import java.util.Properties;

import static org.springframework.beans.factory.config.YamlProcessor.MatchStatus;


@Configuration
@Slf4j
public class PropertySourceConfig implements EnvironmentAware {

    private Environment environment;


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    @Bean(name = "configs")
    public Properties properties() {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();

        yaml.setResources(new ClassPathResource("META-INF/configs.yml"));
        yaml.setDocumentMatchers((properties) -> {
            log.debug("properties: {}", properties);

            String[] profiles = StringUtils.split(properties.getProperty("spring.profiles"), ", ");
            if (environment.acceptsProfiles(profiles)) {
                return MatchStatus.FOUND;
            }
            return MatchStatus.NOT_FOUND;
        });
        return yaml.getObject();
    }


    @Bean
    public PropertySourcesPlaceholderConfigurer configPlaceholder() {
        log.debug("call configPlaceholder");

        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setProperties(properties());
        return propertySourcesPlaceholderConfigurer;
    }


    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource configMessageSource() {
        log.debug("call configMessageSource");

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:META-INF/i18n/messages", "classpath:META-INF/i18n/errors");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(60);

        return messageSource;
    }


    @Bean
    public MessageSourceAccessor configMessageSourceAccessor(MessageSource messageSource) {
        log.debug("call configMessageSourceAccessor");

        LocaleContextHolder.setDefaultLocale(Locale.KOREA);

        MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource);
        CodeMessageAccessor.setMessageSourceAccessor(messageSourceAccessor);

        return new MessageSourceAccessor(messageSource);
    }
}
