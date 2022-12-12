package com.example.rewardsprogram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.rewardsprogram.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
