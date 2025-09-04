package com.kh.statement.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.function.Function;

import com.kh.statement.model.dao.EmployeeDao;
import com.kh.statement.model.vo.Employee;

public class EmployeeService {

	private <T> T executeQuery(Function<Connection, T> daofunction) {
		Connection conn = null;
		T result = null;
		conn = getConnection();
		result = daofunction.apply(conn);

		close(conn);

		return result;

	}

	public List<Employee> findAll() {
		
		return executeQuery(new EmployeeDao()::findAll);
	}
	
	public List<Employee> findByDept(String dept){
		
		return executeQuery(conn -> new EmployeeDao().findByDept(conn,dept));
	}
	
	public List<Employee> findByJob(String job){
		
		return executeQuery(conn -> new EmployeeDao().findByJob(conn,job));
	}

}
