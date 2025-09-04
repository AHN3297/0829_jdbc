package com.kh.statement.controller;

import java.util.List;

import com.kh.statement.model.service.EmployeeService;
import com.kh.statement.model.vo.Employee;


public class EmployeeController {
	
	public List<Employee> findAll() {
			
			List<Employee> employees = new EmployeeService().findAll();
			
			return employees;
		}
	public List<Employee> findByDept(String dept) {
		
		List<Employee> employees = new EmployeeService().findByDept(dept);
		
		return employees;
	}
	
	public List<Employee> findByJob(String job) {
		
		List<Employee> employees = new EmployeeService().findByJob(job);
		
		return employees;
	}
	
	public Employee sellectAll(int num) {
		
	}


}
