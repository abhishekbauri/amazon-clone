package com.example.Amazon.AmazonClone.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.example.Amazon.AmazonClone.aspect","com.example.Amazon.AmazonClone.services"})
@EnableAspectJAutoProxy
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests().
                requestMatchers("/AmazonClone/api/person/savePerson").authenticated().
                requestMatchers("/AmazonClone/api/person/getAllPersons").authenticated().
                requestMatchers("/AmazonClone/api/person/updatePerson").authenticated().
                requestMatchers("/AmazonClone/api/person/getPersonByEmail").authenticated().
                requestMatchers("/AmazonClone/api/product/saveProduct").authenticated().
                requestMatchers("/AmazonClone/api/product/getAllProducts").permitAll().
                requestMatchers("/AmazonClone/api/product//category/{category}").permitAll().
                requestMatchers("/AmazonClone/v3/api-docs").permitAll().
//                requestMatchers("/AmazonClone/api/games/saveNewGame").permitAll().
                requestMatchers("/AmazonClone/api/games/getAllGames").permitAll().
                and().formLogin(withDefaults()).
                httpBasic(withDefaults());

        return http.build();
    }

    @Bean public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return mapper;
    }
}
