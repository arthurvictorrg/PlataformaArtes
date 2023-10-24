package com.br.plataformaArtes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/cliente/**").hasRole("USER")
                .antMatchers("/matricula-cliente/**").hasRole("ADMIN")
                .antMatchers("/registro-consulta/**").hasRole("DIRETOR")
                .antMatchers("/v2/api-docs", "/swagger-resources/**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/swagger-ui/index.html").permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("pabllo").password("senhadifici").roles("ADMIN")
                .and().withUser("joão").password("1234").roles("USER")
                .and().withUser("claudio").password("1234").roles("DIRETOR");


        //.withUser("joão").password(new BCryptPasswordEncoder().encode("1234")).roles("USER");
        //.and().withUser("marcelo").password("1234").roles("DIRETOR");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}