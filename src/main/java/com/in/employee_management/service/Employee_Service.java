package com.in.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.employee_management.model.Employee;
import com.in.employee_management.repository.Employee_repository;

@Service
public class Employee_Service {

	@Autowired
	Employee_repository emp_repo;
	
	
	public Employee employeeAdd(Employee emp) {
		return emp_repo.save(emp);
	}
	
	
	public List<Employee> employeeAllView() {
		return emp_repo.findAll();
	}
	
	public Employee employeeFindById(Integer id) {
		return emp_repo.findById(id)
				.orElseThrow(()-> new RuntimeException("This id is not found"));
	}
	
	public String deleteEmployee(Integer id) {
		
		employeeFindById(id);
			emp_repo.deleteById(id);
			return "Data is deleted successfully";
	}
	
	public Employee updateEmployee(Employee emp, Integer id) {
		    emp_repo.findById(id).orElseThrow(()->new RuntimeException("This id not Match in Database"));
	
		   Employee newEmp = emp_repo.getById(id);
		   newEmp.setName(emp.getName());
		   newEmp.setEmail(emp.getEmail());
		   newEmp.setAge(emp.getAge());
		   newEmp.setAddress(emp.getAddress());
		   newEmp.setDob(emp.getDob());
		   newEmp.setPhone(emp.getPhone());
		   newEmp.setGender(emp.getGender());
		   
		return emp_repo.save(newEmp);
	}
	
	
	
	
}
