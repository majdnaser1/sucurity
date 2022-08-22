package com.example.finalprojecbackend.service;

import com.example.finalprojecbackend.dto.ApiException;
import com.example.finalprojecbackend.model.Customer;
import com.example.finalprojecbackend.model.loginForm;
import com.example.finalprojecbackend.repository.authCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class  authCustomerService {

    private final authCustomerRepository authcustomerRepository;

    public void register(Customer customer) {
        String hashedPassword = new BCryptPasswordEncoder().encode(customer.getPassword());
        customer.setPassword(hashedPassword);
        authcustomerRepository.save(customer);
    }

    public void login(loginForm loginForm) {
        Customer customer = authcustomerRepository.findCustomerByUsernameAndPassword(loginForm.getUsername(), loginForm.getPassword());

        if (customer == null) {
            throw new ApiException("wrong username or password");
        }


    }
}