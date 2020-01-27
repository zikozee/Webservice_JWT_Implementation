package com.zikozee.sprinboot.consumingwebservices.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//REMOVE THIS CLASS AND EVERYTHING WORKS NORMAL WITH NO AUTHENTICATION
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication

        auth.inMemoryAuthentication()
                .withUser("zikozee").password(passwordEncoder().encode("ziko123")).roles("USER")
                .and()
                .withUser("mary").password(passwordEncoder().encode("test123")).roles("USER", "MANAGER")
                .and()
                .withUser("susan").password(passwordEncoder().encode("test123")).roles("USER", "ADMIN");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // secures all REST endpoints under "/users"
        http.authorizeRequests()
                .antMatchers("/users/**").authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Why disable CSRF?
        //
        // Spring Security 5 has CSRF enabled by default. You would need to send over CSRF tokens.
        // However, CSRF generally does not apply for REST APIs. CSRF protection is a request that could be processed by a browser by normal users.
        // If you are only creating a REST service that is used by non-browser clients, you will likely want to disable CSRF protection.
        //
        // For more details, see this link:
        // http://www.tothenew.com/blog/fortifying-your-rest-api-using-spring-security/

        // Why disable sessions?
        //
        // For our application, we would like avoid the use of cookies for sesson tracking. This should force the REST client
        // to enter user name and password for each request. However, this is not always the case depending on the REST client / browser
        // you are using. Your mileage will vary here (for example, this doesn't work in Eclipse embedded browser).
        //
        // For more details, see this link
        // http://www.baeldung.com/spring-security-session

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
