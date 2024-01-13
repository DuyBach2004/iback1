package vn.iback.studentmanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import vn.iback.studentmanager.service.Userservice;

@Configuration
public class SecurityConfig {
    //ma hoa mat khau
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(Userservice userservice){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userservice);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers("/css/**","/image/**").permitAll()
                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("/home/**").authenticated()
                        .requestMatchers("/homeUser/**").hasRole("USER")
                        .requestMatchers("/home/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        ).formLogin(
                form->form.loginPage("/showLoginPage")
                        .loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .successHandler((request, response, authentication) -> {
                            boolean isUser = authentication.getAuthorities().stream()
                                    .anyMatch(r -> r.getAuthority().equals("ROLE_USER"));
                            if (isUser) {
                                response.sendRedirect("/homeUser");
                            } else {
                                response.sendRedirect("/home/showHome");
                            }
                        })
                        .permitAll()
        ).logout(
                logout->logout.permitAll()
        ).exceptionHandling(
                configurer->configurer.accessDeniedPage("/showPage403")
        );

        return http.build();
    }


}
