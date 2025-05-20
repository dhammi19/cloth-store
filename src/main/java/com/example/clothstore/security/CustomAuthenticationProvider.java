package com.example.clothstore.security;

import com.example.clothstore.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
// @Component: để Spring Boot tự phát hiện và quản lý bean này.
@Component
/*
    - AuthenticationProvider dùng để thực hiện xác thực (xác minh username/password đúng hay sai)
    - Vì Spring Security không biết bạn muốn xác thực bằng cách nào: Dùng username/password
     database? Dùng file? Dùng LDAP? Dùng API bên ngoài? Do đó nó cung cấp cho bạn một hợp đồng
     (interface) tên là AuthenticationProvider để bạn tự hiện thực theo cách bạn muốn.
     - Khi bạn viết CustomAuthenticationProvider implements AuthenticationProvider, tức là bạn
     đang nói: “Tôi sẽ tự viết cách để xác thực người dùng!”
     - Vì sao cần implement? Vì bạn muốn kiểm soát cách xác thực (dùng DB, file, API, v.v.)
     thay vì dùng mặc định
*/
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    StaffService staffService;

    @Override
    /*
        - Authentication Đại diện cho thông tin xác thực của người dùng (username, password,
        roles, trạng thái)
        - Authentication giống như một cái "hồ sơ đăng nhập" mà Spring Security xử lý.
        - AuthenticationProvider là người kiểm tra hồ sơ đó xem có hợp lệ không.
    */
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // authentication.getName() lấy username từ form login.
        String userName = authentication.getName();

        // authentication.getCredentials() lấy mật khẩu từ form login.
        String password = authentication.getCredentials().toString();

        boolean isSuccess= staffService.isLoggedIn(userName, password);

        if (isSuccess) {
            /*
                - Authentication là một interface trừu tượng đại diện cho thông tin xác thực
                - UsernamePasswordAuthenticationToken là một implementation cụ thể của Authentication,
                dùng cho login bằng username/password
                - Authentication: như một cái "form login" tổng quát, không quan tâm là kiểu gì
                (username, token, fingerprint...)
                - UsernamePasswordAuthenticationToken: như một bản đăng nhập dùng tài khoản + mật khẩu.
                - Vì ta xác thực kiểu username và password nên ta phải return về kiểu
                UsernamePasswordAuthenticationToken
            */
            return new UsernamePasswordAuthenticationToken(userName, password, new ArrayList<>());
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
