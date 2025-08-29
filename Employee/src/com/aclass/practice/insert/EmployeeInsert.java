package com.aclass.practice.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeInsert {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset =null;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		// 사원번호(int), 이름, 주민번호(String), 이메일, 휴대폰 번호(String), 부서코드(String), 직급코드(String)
		// 급여 등급(String), 급여(int), 보너스(double), 관리 아이디(int), 입사일 (sysdate), 		
		System.out.println("사원번호를입력해주세요.");
		int en = sc.nextInt();
		sc.nextLine();
		System.out.println("사원의 이름을 입력해주세요");
		String name = sc.nextLine();
		System.out.println("주민번호를 입력해주세요");
		String pnum = sc.nextLine();
		System.out.println("이메일을 입력해주세요");
		String email = sc.nextLine();
		System.out.println("휴대폰 번호를 입력해주세요('-'포함)");
		String phone = sc.nextLine();
		System.out.println("부서코드를 입력해주세요");
		String dc = sc.nextLine();
		System.out.println("직급코드를입력해주세요");
		String jc = sc.nextLine();
		System.out.println("급여등급을 입력해주세요");
		String sl = sc.nextLine();
		System.out.println("급여를 입력해주세요");
		String salary = sc.nextLine();
		System.out.println("보너스를 입력해주세요");
		double bonus = sc.nextDouble();
		System.out.println("관리아이디를 입력해주세요");
		int mn = sc.nextInt();
		
		String sql = "INSERT "
				     + "INTO "
				          + "EMPLOYEE "
				   + "VALUES"
				          + "(" 
				          + en 
				          + " , '" + name + "'"
				          + " , '" + pnum + "'"
				          + " , '" + email + "'"
				          + " , '" + phone + "'"
				          + " , '" + dc + "'"
				          + " , '" + jc + "'"
				          + " , '" + sl + "'"
				          + " , '" + salary + "'"
				          + " , '" + bonus + "'"
				          + " , '" + mn + "'"
				          +", SYSDATE"
				          + ")";
		try {
			// 1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver등록 성공!");
			// 2.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "AYS14", "AYS141234");
			System.out.println("DB서버 접속 성공!");
			
			conn.setAutoCommit(false);
			
			// 3.
			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성!");
			
			// 4.
			result = stmt.executeUpdate(sql);
			System.out.println("SQL문 실행 성공!");
			
			// 5.
			if(result > 0) { 
				conn.commit();
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace(); 
			System.out.println("프로젝트에 OJDBC를 추가하였나요?");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("사용자이름/비밀번호가 잘못됐습니다. ");
			System.out.println("부적합한 Oracle URL이 지정되었습니다.");
			System.out.println("SQL SYNTAX EXception");
			System.out.println("NULLPointException");
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
					
	}

}
