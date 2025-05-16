package com.example.clothstore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {
    /*
        Dùng để khởi tạo danh sách user cứng và danh sách user này sẽ được lưu
        trữ ở ram
    */
    @Bean
    public InMemoryUserDetailsManager userDetailService() {
        UserDetails user1 = User
                .withUsername("cybersoft")
                .password(passwordEncoder().encode("123"))
                .roles("USERS").build();

        UserDetails user2 = User
                .withUsername("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    // Kiểu mã hóa dữ liệu
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
        Quy định các rule liên quan tới bảo mật và quyền truy cập
    */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
