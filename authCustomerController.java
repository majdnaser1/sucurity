package com.example.finalprojecbackend.controller;

import com.example.finalprojecbackend.dto.ApiResponse;
import com.example.finalprojecbackend.model.Customer;
import com.example.finalprojecbackend.model.loginForm;
import com.example.finalprojecbackend.service.authCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth2")
public class authCustomerController {
    private final authCustomerService authcustomerservice ;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid Customer customer){
        authcustomerservice.register(customer);
        return ResponseEntity.status(201).body(new ApiResponse("New user added !",201));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody loginForm loginform){
        authcustomerservice.login(loginform);
        return ResponseEntity.status(200).body(new ApiResponse("Welcome back !",200));
    }



}
