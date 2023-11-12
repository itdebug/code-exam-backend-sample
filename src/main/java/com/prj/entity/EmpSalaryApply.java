package com.prj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/12
 * @地址 https://github.com/itdebug/
 * @描述
 */
@Entity(name = "emp_salary_apply")
public class EmpSalaryApply {

	@Id
	private String id;

	private String empId;

	private String empName;

	private String empDept;

	private String empPosition;

	private Double empSalary;
	private String manager;
	private Double approveRate;
	private Double approveSalary;
	private String approveAdvice;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date approveDate;

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Double getApproveSalary() {
		return approveSalary;
	}

	public void setApproveSalary(Double approveSalary) {
		this.approveSalary = approveSalary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpPosition() {
		return empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public Double getApproveRate() {
		return approveRate;
	}

	public void setApproveRate(Double approveRate) {
		this.approveRate = approveRate;
	}

	public String getApproveAdvice() {
		return approveAdvice;
	}

	public void setApproveAdvice(String approveAdvice) {
		this.approveAdvice = approveAdvice;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
}
