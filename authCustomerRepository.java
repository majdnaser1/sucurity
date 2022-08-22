package com.example.finalprojecbackend.repository;

import com.example.finalprojecbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authCustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findUserByUsername(String username);

    Customer findCustomerByUsernameAndPassword(String username,String password);
}
