package configs.spring;


import com.oakfusion.security.CookieSecurityContextRepository;
import com.oakfusion.security.SecurityCookieService;
import com.spring.handler.LoginAuthenticationFailureHandler;
import com.spring.handler.LoginAuthenticationSuccessHandler;
import com.spring.service.commons.impl.FoUserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.savedrequest.NullRequestCache;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth
                // .inMemoryAuthentication().withUser("user").password("password").roles("USER");
                .authenticationProvider(authenticationProvider());
        // @formatter:on
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        // @formatter:off
        web
                .ignoring()
                .antMatchers("/resources/**", "/favicon.ico")
                .antMatchers("/embed/**");
        // @formatter:on
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .requestCache().disable()
                .securityContext()
                .securityContextRepository(securityContextRepository())
                .and()
                .requestCache().requestCache(new NullRequestCache())
                .and()
                .anonymous()
                .authorities("ROLE_ANONYMOUS")
                .and()
                .headers()
                .frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/security/**", "/index.jsp", "/main/**", "/sample.jsp").permitAll()
                .antMatchers("/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/security/login")
                .loginProcessingUrl("/security/_login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/security/_logout")
                .logoutSuccessUrl("/security/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "SPRING_SECURITY_REMEMBER_ME_COOKIE")
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .and()
                .csrf().disable();

        // @formatter:on
    }


    @Bean
    public static SecurityContextRepository securityContextRepository() {
        return new CookieSecurityContextRepository(securityCookieService());
    }


    private static SecurityCookieService securityCookieService() {
        return new SecurityCookieService("_sit_f", "38df0904a41f11e7");
    }


    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean("authenticationProvider")
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }


    @Bean("userDetailService")
    public UserDetailsService userDetailsService() {
        return new FoUserDetailsServiceImpl();
    }


    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        LoginAuthenticationSuccessHandler authenticationSuccessHandler = new LoginAuthenticationSuccessHandler();
        authenticationSuccessHandler.setDefaultTargetUrl("/contents/manager/contents");
        return authenticationSuccessHandler;
    }


    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        LoginAuthenticationFailureHandler authenticationFailureHandler = new LoginAuthenticationFailureHandler();
        authenticationFailureHandler.setUsernameParameter("username");
        authenticationFailureHandler.setDefaultFailureUrl("/security/login?error=true");

        return authenticationFailureHandler;
    }


    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
        accessDeniedHandler.setErrorPage("/WEB-INF/views/error/403-forbidden.jsp");

        return accessDeniedHandler;
    }
}
