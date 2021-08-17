package com.example.employee.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entity.Employee;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;

	@PostMapping(value="/post",consumes=MediaType.ALL_VALUE)
	public ResponseEntity<?> create(){
		Employee emp1=new Employee(1,"sejal","hyderabad",new Timestamp(23));
		Employee emp2=new Employee(2,"archit","delhi",new Timestamp(23));
		Employee emp3=new Employee(3,"saloni","kolkata",new Timestamp(23));
		Employee emp4=new Employee(4,"saurabh","ranchi",new Timestamp(23));

		List<Employee> list=new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		employeeDao.saveAll(list);
		return new ResponseEntity<String>("saved",HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Employee> getById(@PathVariable int id){
		Optional<Employee> result=employeeDao.findById(id);
		return new ResponseEntity<Employee>(result.get(),HttpStatus.OK);
	}
	 
	@GetMapping(value="/get")
	public ResponseEntity<List<Employee>> getAll(){
		return new ResponseEntity<List<Employee>>(employeeDao.findAll(),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteMapping(@PathVariable int id){
		employeeDao.deleteById(id);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}
	
	

}
