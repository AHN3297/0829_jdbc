package com.kh.statement.model.vo;

import java.util.Objects;

public class Employee {
	// 사번EMP_ID, 사원명EMP_NAME, 급여SALARY, 부서명DEPT_TITLE, 직급명JOB_NAME
	// -> JOB, DEPARTMENT JOIN
	
	private int empId;
	private String empName;
	private int salary;
	private String EmpNo;
	private String Email;
	private String Phone;
	private String DeptCode;
	private String JobCode;
	private String SalLevel;
	private double Bounus;
	private int ManagerId;
	private String HireDate;
	private String EntDate;
	private String EntYn;
	private String deptTitle;
	private String jobName;
	
	public Employee() {
		super();
	}
	
	public String getEmpNo() {
		return EmpNo;
	}

	public void setEmpNo(String empNo) {
		EmpNo = empNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getDeptCode() {
		return DeptCode;
	}

	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}

	public String getJobCode() {
		return JobCode;
	}

	public void setJobCode(String jobCode) {
		JobCode = jobCode;
	}

	public String getSalLevel() {
		return SalLevel;
	}

	public void setSalLevel(String salLevel) {
		SalLevel = salLevel;
	}

	public double getBounus() {
		return Bounus;
	}

	public void setBounus(double bounus) {
		Bounus = bounus;
	}

	public int getManagerId() {
		return ManagerId;
	}

	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}

	public String getHireDate() {
		return HireDate;
	}

	public void setHireDate(String hireDate) {
		HireDate = hireDate;
	}

	public String getEntDate() {
		return EntDate;
	}

	public void setEntDate(String entDate) {
		EntDate = entDate;
	}

	public String getEntYn() {
		return EntYn;
	}

	public void setEntYn(String entYn) {
		EntYn = entYn;
	}

	public Employee(int empId, String empName, int salary, String empNo, String email, String phone, String deptCode,
			String jobCode, String salLevel, double bounus, int managerId, String hireDate, String entDate,
			String entYn, String deptTitle, String jobName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		EmpNo = empNo;
		Email = email;
		Phone = phone;
		DeptCode = deptCode;
		JobCode = jobCode;
		SalLevel = salLevel;
		Bounus = bounus;
		ManagerId = managerId;
		HireDate = hireDate;
		EntDate = entDate;
		EntYn = entYn;
		this.deptTitle = deptTitle;
		this.jobName = jobName;
	}

	public Employee(int empId, String empName, int salary, String deptTitle, String jobName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.deptTitle = deptTitle;
		this.jobName = jobName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDeptTitle() {
		return deptTitle;
	}
	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", EmpNo=" + EmpNo
				+ ", Email=" + Email + ", Phone=" + Phone + ", DeptCode=" + DeptCode + ", JobCode=" + JobCode
				+ ", SalLevel=" + SalLevel + ", Bounus=" + Bounus + ", ManagerId=" + ManagerId + ", HireDate="
				+ HireDate + ", EntDate=" + EntDate + ", EntYn=" + EntYn + ", deptTitle=" + deptTitle + ", jobName="
				+ jobName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Bounus, DeptCode, Email, EmpNo, EntDate, EntYn, HireDate, JobCode, ManagerId, Phone,
				SalLevel, deptTitle, empId, empName, jobName, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(Bounus) == Double.doubleToLongBits(other.Bounus)
				&& Objects.equals(DeptCode, other.DeptCode) && Objects.equals(Email, other.Email)
				&& Objects.equals(EmpNo, other.EmpNo) && Objects.equals(EntDate, other.EntDate)
				&& Objects.equals(EntYn, other.EntYn) && Objects.equals(HireDate, other.HireDate)
				&& Objects.equals(JobCode, other.JobCode) && ManagerId == other.ManagerId
				&& Objects.equals(Phone, other.Phone) && Objects.equals(SalLevel, other.SalLevel)
				&& Objects.equals(deptTitle, other.deptTitle) && empId == other.empId
				&& Objects.equals(empName, other.empName) && Objects.equals(jobName, other.jobName)
				&& salary == other.salary;
	}
	
	

}
