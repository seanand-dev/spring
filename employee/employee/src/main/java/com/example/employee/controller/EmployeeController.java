package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entity.Employee;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@GetMapping(value="/get")
	public ResponseEntity<List<Employee>> getAll(){
		return new ResponseEntity<List<Employee>>(employeeDao.findAll(),HttpStatus.OK);
	}
	
	

}
