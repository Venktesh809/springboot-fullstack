package com.in.employee_management.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "employee_mng")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	@Min(value = 1000000000L, message = "Phone must be 10 digits")
	@Max(value = 9999999999L, message = "Phone must be 10 digits")
	private long phone;

	@Column(nullable = false)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dob;

	@Column(nullable = false)
	private String address;

}
