package com.curso.boot.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Office")
public class Cargo extends AbstractEntity<Long> {
	@Column(nullable = false, length = 60)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "department")
	private Departamento department;
	
	@OneToMany(mappedBy = "office")
	private List<Funcionario> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Departamento getDepartment() {
		return department;
	}

	public void setDepartment(Departamento department) {
		this.department = department;
	}
}
