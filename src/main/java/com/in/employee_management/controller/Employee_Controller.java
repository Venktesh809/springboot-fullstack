package com.in.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in.employee_management.model.Employee;
import com.in.employee_management.service.Employee_Service;

@RestController
@RequestMapping("/employee")
public class Employee_Controller {
	
	@Autowired
	Employee_Service emp_service;
	
	@PostMapping("/add")
	public Employee employee_add(@RequestBody Employee emp) {
		return emp_service.employeeAdd(emp);
	}
	
	@GetMapping("/view")
	public List<Employee> allemployee_Views(){
		return emp_service.employeeAllView();
	}
	
	@GetMapping("/view/id")
	public Employee findById(@RequestParam Integer id) {
		return emp_service.employeeFindById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void employeeDeleteById(@PathVariable Integer id) {
		emp_service.deleteEmployee(id);
	}

	@PutMapping("/update/id")
	public Employee updateEmployee(@RequestBody Employee emp , @RequestParam Integer id) {
		 return emp_service.updateEmployee(emp, id);
	}
}
