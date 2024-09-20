package com.jsnunez.antiguedades.aplication.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jsnunez.antiguedades.infrastructure.adapter.UserDetailServiceImpl;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para simplificar
                  .httpBasic(Customizer.withDefaults())
                // .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> {

                auth.requestMatchers("/css/**", "/js/**", "/images/**").permitAll();
                auth.requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN");
          
                auth.requestMatchers(HttpMethod.PUT, "/api/**").permitAll();
                auth.requestMatchers(HttpMethod.POST, "/api/**").permitAll();
                auth.requestMatchers(HttpMethod.DELETE, "/api/**").permitAll();
                // Endpoints privados
       
             
                auth.anyRequest().hasAnyRole("ADMIN");
            })
            .formLogin(form -> form
                .loginPage("/login") // Página personalizada de inicio de sesión
                .defaultSuccessUrl("/home", true) // Redirigir al usuario a /home después de iniciar sesión
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout") // Redirige a la página de inicio de sesión después de cerrar sesión
                .permitAll()
            )
            .build();
    }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
    // throws Exception {
    // return httpSecurity
    // .csrf(csrf -> csrf.disable())
    // .httpBasic(Customizer.withDefaults())
    // .sessionManagement(session ->
    // session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    // .build();
    // }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
