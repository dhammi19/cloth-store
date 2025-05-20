package com.example.clothstore.controller;

import com.example.clothstore.payload.request.SignInRequest;
import com.example.clothstore.payload.response.DataResponse;
import com.example.clothstore.service.StaffService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    StaffService staffService;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("")
    public String hello() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Current user: " + auth.getName());
        return "Hello you";
    }

    @PostMapping("/sign-in")
    public ResponseEntity<DataResponse> signIn(@RequestBody SignInRequest signInRequest, HttpServletRequest request) {
        /*
            - Tạo một đối tượng Authentication đại diện cho yêu cầu đăng nhập, chứa username và password.
            Sau này sẽ được truyền vào AuthenticationManager để xác thực.
        */
        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getUsername(),
                        signInRequest.getPassword());

        /*
            - Gửi authRequest cho AuthenticationManager để xử lý xác thực
            - Nếu username/password đúng, nó trả về Authentication đã xác thực (isAuthenticated = true)
            - Nếu sai, sẽ ném ra BadCredentialsException
        */
        Authentication auth = authenticationManager.authenticate(authRequest);

        /*
            - Tạo SecurityContext để chứa thông tin người dùng vừa xác thực.
            - Đây là cách Spring Security lưu thông tin người dùng đã login.
        */
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(auth);

        //  Lưu SecurityContext vào HttpSession dưới key mặc định của Spring:
        HttpSession session = request.getSession(true);
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                securityContext
        );

        DataResponse dataResponse = new DataResponse();
        dataResponse.setStatusCode(HttpStatus.OK.value());
//        dataResponse.setSuccess(result);
        dataResponse.setDescription("Sign in successfully");
        dataResponse.setData("");

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
//        DataResponse dataResponse = new DataResponse();
//
//        boolean result = staffService.isLoggedIn(signInRequest.getUsername(), signInRequest.getPassword());
//        dataResponse.setSuccess(result);
//
//        if (result) {
//            dataResponse.setDescription("Sign in successfully");
//            dataResponse.setStatusCode(HttpStatus.OK.value());
//            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
//        } else {
//            dataResponse.setDescription("Login failed");
//            dataResponse.setStatusCode(HttpStatus.OK.value());
//            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
//        }
    }
}
