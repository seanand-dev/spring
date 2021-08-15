package com.example.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Employee> findAll(){
		
		return jdbcTemplate.query("select * from employee", new BeanPropertyRowMapper(Employee.class));
	}

}
