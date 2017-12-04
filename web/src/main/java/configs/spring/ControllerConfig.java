package configs.spring;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.concurrent.TimeUnit;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.controller")
public class ControllerConfig extends WebMvcConfigurerAdapter {

    @Value("${server.upload.root.path}")
    private String resourceRootPath;


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // configurer.enable();
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // @formatter:off
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES).cachePublic());

        registry
                .addResourceHandler("/uploads/**")
                .addResourceLocations(String.format("file:%s/", resourceRootPath))
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES).cachePublic());

        registry
                .addResourceHandler("/favicon.ico")
                .addResourceLocations("/resources/images/favicon.ico")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES).cachePublic());
        // @formatter:on
    }


    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver createMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");

        return resolver;
    }

}
