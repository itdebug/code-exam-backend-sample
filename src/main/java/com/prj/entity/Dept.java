package com.prj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/11
 * @地址 https://github.com/itdebug/
 * @描述
 */
@Entity(name = "dept")
public class Dept {

	@Id
	private String id;
	private String manager;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
