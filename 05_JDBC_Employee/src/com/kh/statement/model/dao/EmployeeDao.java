package com.kh.statement.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.statement.model.vo.Employee;


public class EmployeeDao {
	
	private Properties prop = new Properties();
	
	public EmployeeDao(){
		try {
			prop.loadFromXML(new FileInputStream("resources/member-Mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> findAll(Connection conn) {
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findAll");
		System.out.println("성공!");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee(rset.getInt("EMP_ID")
										  ,rset.getString("EMP_NAME")
										  ,rset.getInt("SALARY")
										  ,rset.getString("DEPT_TITLE")
										  ,rset.getString("JOB_NAME"));
										  
				employees.add(employee);
				                          
			}
			rset = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return employees;
	}
	
	public List<Employee> findByDept(Connection conn, String dept){
		
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByDept");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  dept);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee(rset.getInt("EMP_ID")
										  ,rset.getString("EMP_NAME")
										  ,rset.getInt("SALARY")
										  ,rset.getString("DEPT_TITLE")
										  ,rset.getString("JOB_NAME"));	 
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return employees;
	}
	
public List<Employee> findByJob(Connection conn, String job){
		
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByJob");
		System.out.println("성공?");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  job);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee(rset.getInt("EMP_ID")
										  ,rset.getString("EMP_NAME")
										  ,rset.getInt("SALARY")
										  ,rset.getString("DEPT_TITLE")
										  ,rset.getString("JOB_NAME"));	 
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return employees;
	}

}
