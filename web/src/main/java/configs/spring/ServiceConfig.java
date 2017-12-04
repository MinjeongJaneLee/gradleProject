package configs.spring;


import com.spring.utility.policy.AlphabeticFileRenamePolicy;
import com.spring.utility.policy.FileRenamePolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("com.spring.service.**")
@EnableTransactionManagement
public class ServiceConfig {

    @Bean
    public FileRenamePolicy alphabeticFileRenamePolicy() {
        return new AlphabeticFileRenamePolicy();
    }
}
