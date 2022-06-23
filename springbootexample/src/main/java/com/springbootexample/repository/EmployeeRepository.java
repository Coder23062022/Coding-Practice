package com.springbootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootexample.model.employee;

public interface EmployeeRepository extends JpaRepository<employee, Long>{

}
