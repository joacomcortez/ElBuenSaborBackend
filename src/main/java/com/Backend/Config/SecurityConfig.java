package com.Backend.Config;



import com.Backend.Jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                                authRequest
                                        //Autenticacion
                                        .requestMatchers(new AntPathRequestMatcher("/auth/registrarEmpleado")).permitAll()
//                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/rubroArticulos")).permitAll()
//                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/rubroArticulos/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()


                                        //Consola H2:
                                        .requestMatchers(PathRequest.toH2Console()).permitAll()

                                        //Autorizacion de acceso a la url:
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/demoAdmin/**")).hasAuthority("ADMINISTRADOR")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/demoUser/**")).hasAuthority("CLIENTE")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/**")).permitAll()


                )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2
                .sessionManagement(sessionManager->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();


    }

}