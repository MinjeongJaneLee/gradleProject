package configs.spring;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({ PropertySourceConfig.class, RepositoryConfig.class, ServiceConfig.class, SecurityConfig.class, ControllerConfig.class })
public class RootContext {

}
