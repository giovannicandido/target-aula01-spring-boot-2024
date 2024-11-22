package br.com.eadtt.aula01.config;

import com.c4_soft.springaddons.security.oidc.starter.synchronised.resourceserver.ResourceServerExpressionInterceptUrlRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class WebSecurityConfig {


    @Bean
    public ResourceServerExpressionInterceptUrlRegistryPostProcessor securityConfig() {
        return (AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) ->
                registry
                        .requestMatchers(HttpMethod.GET, "/v0/oficinas").permitAll()
                        .requestMatchers("/v3/api-docs/**").permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/swagger-ui.html").permitAll()
                        .requestMatchers(HttpMethod.GET, "/actuator/**").hasAuthority("backend.observability:read")
                        .requestMatchers("/actuator/**").hasAuthority("backend.observability:write")
                        .anyRequest().authenticated();
    }
}
