package com.example.clothstore.security;

import com.example.clothstore.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {
    /*
        Dùng để khởi tạo danh sách user cứng và danh sách user này sẽ được lưu
        trữ ở ram
    */
//    @Bean
//    public InMemoryUserDetailsManager userDetailService() {
//        UserDetails user1 = User
//                .withUsername("cybersoft")
//                .password(passwordEncoder().encode("123"))
//                .roles("USERS").build();
//
//        UserDetails user2 = User
//                .withUsername("admin")
//                .password(passwordEncoder().encode("admin123"))
//                .roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    JwtTokenFilter jwtTokenFilter;

    /*
        - AuthenticationManager Là trung tâm xử lý xác thực người dùng trong Spring Security
        với vai trò chính là Điều phối, gọi đến AuthenticationProvider để xác thực
        - Tạo một AuthenticationManager đã được cấu hình với CustomAuthenticationProvider,
        sau đó Spring có thể dùng nó để xác thực người dùng trong quá trình đăng nhập.
    */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        /*
            - HttpSecurity là đối tượng cấu hình bảo mật HTTP (login, logout, quyền truy cập,
            CSRF, v.v.)
            - AuthenticationManagerBuilder là nơi bạn cấu hình cách xác thực người dùng
            (qua database, bộ nhớ, custom provider...).
            -
        */
        AuthenticationManagerBuilder authenticationManagerBuilder =
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        /*
            - Bạn đăng ký một AuthenticationProvider tùy chỉnh (trong trường hợp này là
            CustomAuthenticationProvider) cho builder.
            - Tức là: "khi xác thực, hãy dùng custom logic của tôi để kiểm tra
            username và password".
        */
        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);

        /*
            - Sau khi cấu hình xong, bạn dùng .build() để tạo ra một AuthenticationManager
            thực sự.
            - Spring sẽ dùng AuthenticationManager này trong controller hoặc bên trong
            SecurityContext để xác thực người dùng.
        */
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
        - Quy định các rule liên quan tới bảo mật và quyền truy cập
    */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home-page/*").permitAll()
                        .requestMatchers("/product-type/*").permitAll()
                        .requestMatchers("/file/**").permitAll()
                        .requestMatchers("/admin/sign-in").permitAll()
                        .requestMatchers("/refresh-token").permitAll()
                        .anyRequest().authenticated());

        /*
            - Thêm filter trước một filter nào đó
        */
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}