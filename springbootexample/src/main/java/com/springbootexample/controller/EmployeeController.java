package com.springbootexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootexample.dao.EmployeeDAO;
import com.springbootexample.model.employee;

@RestController
@RequestMapping("/hello")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;

	@PostMapping("/employees")
	public employee createEmployee(@Valid @RequestBody employee emp) {
		return employeeDAO.save(emp);
	}

	@GetMapping("/employees")
	public List<employee> getAllEmployees() {
		return employeeDAO.findAll();
	}

	// update an employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<employee> updateEmployee(@PathVariable(value = "id") Long empid,
			@Valid @RequestBody employee empDetails) {
		employee emp = employeeDAO.findOne(empid);

		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setName(empDetails.getName());
		emp.setAddress(empDetails.getAddress());
		emp.setSalary(empDetails.getSalary());

		employee updateEmployee = employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
	}

	// delete an employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<employee> deleteEmployee(@PathVariable(value = "id") Long empid) {

		employee emp = employeeDAO.findOne(empid);

		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		return ResponseEntity.ok().build();
	}
}