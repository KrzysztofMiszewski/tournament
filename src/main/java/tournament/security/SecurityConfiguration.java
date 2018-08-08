package tournament.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/api/users", "/index.html", "/", "/login.html").permitAll()
                .antMatchers("/img/**").permitAll()
                .anyRequest().authenticated();
        //  http.httpBasic();
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/logging_success_page")
                .permitAll();
        http.logout()
                .logoutUrl("/logout")
                .permitAll();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
