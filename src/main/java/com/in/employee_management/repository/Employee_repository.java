package com.in.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.employee_management.model.Employee;

@Repository
public interface Employee_repository extends JpaRepository<Employee, Integer>{

}
