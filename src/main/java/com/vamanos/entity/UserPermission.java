package com.vamanos.entity;
import javax.persistence.Entity;

@Entity
public class UserPermission extends BaseIdEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}