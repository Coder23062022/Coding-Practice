package com.springbootexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootexample.model.employee;
import com.springbootexample.repository.EmployeeRepository;

@Repository
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeerepository;

	public employee save(employee emp) {
		return employeerepository.save(emp);
	}

	public List<employee> findAll() {
		return employeerepository.findAll();
	}

	public employee findOne(Long empid) {
		return employeerepository.findById(empid).get();
	}

	public void delete(employee emp) {
		employeerepository.delete(emp);
	}
}