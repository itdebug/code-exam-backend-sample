package com.prj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/11
 * @地址 https://github.com/itdebug/
 * @描述
 */
@Entity(name = "employee")
public class Employee {

	@Id
	private String id;
	private String name;
	private String dept;

	@Transient
	private String manager;
	private String position;
	private Double salary;

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
