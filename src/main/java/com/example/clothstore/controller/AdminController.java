package com.example.clothstore.controller;

import com.example.clothstore.entity.Staff;
import com.example.clothstore.payload.request.SignInRequest;
import com.example.clothstore.payload.response.DataResponse;
import com.example.clothstore.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    StaffService staffService;

    @PostMapping("/sign-in")
    public ResponseEntity<DataResponse> SignIn(@RequestBody SignInRequest signInRequest) {
        DataResponse dataResponse = new DataResponse();

        boolean result = staffService.isLoggedIn(signInRequest.getUsername(), signInRequest.getPassword());
        dataResponse.setSuccess(result);

        if (result) {
            dataResponse.setDescription("Sign in successfully");
            dataResponse.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } else {
            dataResponse.setDescription("Login failed");
            dataResponse.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        }
    }
}
