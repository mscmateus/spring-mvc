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
@Table(name = "Cargo")
public class Cargo extends AbstractEntity<Long> {
	@Column(nullable = false, length = 60)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "departmento")
	private Departamento departmento;
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartmento() {
		return departmento;
	}

	public void setDepartmento(Departamento departmento) {
		this.departmento = departmento;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
