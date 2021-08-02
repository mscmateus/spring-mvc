package com.curso.boot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Department")
public class Departamento extends AbstractEntity<Long> {
	@Column(nullable = false, length = 60)
	private String name;
	
	@OneToMany(mappedBy = "department")	
	private List<Cargo> offices;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
