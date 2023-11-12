package com.prj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/12
 * @地址 https://github.com/itdebug/
 * @描述
 */
@Entity(name = "employee_kpi")
public class EmpKpi {

	@Id
	private String id;

	private String employeeID;
	private String employeeName;
	private String kpi;
	private String leader;
	private String comments;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date check_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCheck_date() {
		return check_date;
	}

	public void setCheck_date(Date check_date) {
		this.check_date = check_date;
	}
}
