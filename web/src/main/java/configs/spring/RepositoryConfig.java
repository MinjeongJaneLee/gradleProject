package configs.spring;


import com.github.pagehelper.PageInterceptor;
import com.spring.utility.mybatis.YesNoBooleanTypeHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.AutoMappingUnknownColumnBehavior;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.h2.tools.RunScript;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@MapperScan("com.spring.mapper")
@Slf4j
public class RepositoryConfig {


    @Bean(destroyMethod = "close")
    @Profile("local")
    // @formatter:off
    public DataSource dataSource(Environment env,
                                 @Value("${jdbc.driverClassName}") String driverClassName,
                                 @Value("${jdbc.url}") String url,
                                 @Value("${jdbc.username}") String username,
                                 @Value("${jdbc.password}") String password,
                                 @Value("${jdbc.maxIdle:10}") Integer maxIdle) {
        log.debug("[dev, local].dateSource : {}", driverClassName);

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxIdle(maxIdle);

        if (env.acceptsProfiles("local") && Boolean.FALSE) {
            runScript(dataSource);
        }

        return dataSource;
    }
    // @formatter:on


    @Bean(destroyMethod = "close")
    @Profile("!local")
    public DataSource jndiDataSource(@Value("${jdbc.jndiName:jdbc/SampleDS}") String jndiName) {
        return new JndiDataSourceLookup().getDataSource(jndiName);
    }


    private void runScript(BasicDataSource dataSource) {
        log.debug("runScript");

        try (Reader reader = new InputStreamReader(new ClassPathResource("META-INF/schema.ddl").getInputStream(), StandardCharsets.UTF_8);
             Connection conn = dataSource.getConnection()) {
            RunScript.execute(conn, reader);
        } catch (IOException | SQLException e) {
            log.warn(e.getMessage(), e);
        }
    }


    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(applicationContext.getResources("classpath:META-INF/mybatis/**/*Mapper.xml"));

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setAutoMappingUnknownColumnBehavior(AutoMappingUnknownColumnBehavior.WARNING);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.getTypeHandlerRegistry().register(YesNoBooleanTypeHandler.class);
        configuration.addInterceptor(pageInterceptor());

        bean.setConfiguration(configuration);

        return bean.getObject();
    }


    @Bean
    public PageInterceptor pageInterceptor() {
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("pageSizeZero", "true");

        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(properties);

        return pageInterceptor;
    }
}
