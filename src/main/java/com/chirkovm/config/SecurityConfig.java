package com.chirkovm.config;

import com.chirkovm.security.UserDetailsServiceImpl;
import com.chirkovm.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@ComponentScan("com.chirkovm")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().cacheControl().disable();
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("ADMIN");
        http
                .csrf().disable().cors().disable()
                .formLogin().failureUrl("/admin?error").defaultSuccessUrl("/admin/orders").loginPage("/admin").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/admin?logout")).logoutSuccessUrl("/admin?logout").deleteCookies("remember-me").permitAll()
                .and()
                .rememberMe();

        /*http.authorizeRequests()
                .antMatchers("/admin/registration").hasRole()
                .anyRequest().permitAll(); */
    }

    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(bcryptPasswordEncoder());
    }
}
