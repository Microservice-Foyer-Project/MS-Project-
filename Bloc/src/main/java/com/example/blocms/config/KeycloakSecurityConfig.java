package com.example.blocms.config;

import lombok.RequiredArgsConstructor;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/*@KeycloakConfiguration
@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)

public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        super.configure(http);
        http.csrf()
                .disable()
                .httpBasic()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/*").hasAuthority("user")
                .and()
                .authorizeRequests()
                .antMatchers("/candidats/user/*").hasAuthority("user")
                .and()
                .authorizeRequests()
                .antMatchers("/candidats/admin/**").hasAuthority("admin")
                .anyRequest()
                .authenticated();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .requestMatchers("/api/*").hasAuthority("user")
                .requestMatchers("/candidats/user/*").hasAuthority("user")
                .requestMatchers("/candidats/admin/**").hasAuthority("admin")
                .anyRequest().authenticated();
    }


    @Override
    public void init(WebSecurity builder) throws Exception {

    }

    @Override
    public void configure(WebSecurity builder) throws Exception {

    }
}*/
