package com.example.ventevoiture.Config;

import com.example.ventevoiture.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                                        .requestMatchers("/auth/**").permitAll()
                                        .requestMatchers("/annonce/list").permitAll()
                                        .requestMatchers("/annonce/lastid").permitAll()
                                        .requestMatchers("/annonce/rechercher").permitAll()
                                        .requestMatchers("/marque/list").permitAll()
                                        .requestMatchers("/energie/list").permitAll()
                                        .requestMatchers("/boite_vitesse/list").permitAll()
                                        .requestMatchers("/categorie/list").permitAll()
                                        .requestMatchers("/annonce/get/**").permitAll()
                                        .requestMatchers("/voiture/list").permitAll()
                                        .requestMatchers("/voiture/getlast").permitAll()

                        // controller annonce admin
                                        .requestMatchers("/annonce/valider/**").hasAuthority("ADMIN")
                                        .requestMatchers(HttpMethod.PUT,"/marque/**").hasAuthority("ADMIN")
                                        .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                                        .anyRequest().authenticated())
                .sessionManagement(sessionManagement -> sessionManagement
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
