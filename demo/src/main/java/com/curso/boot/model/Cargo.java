package com.curso.boot.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cargo")
public class Cargo extends AbstractEntity<Long> {
	@NotBlank(message = "Informe um nome")
	@Size(min = 3, max= 60, message = "O nome do cargo deve ter entre {min} e {max} caracteres!")
	@Column(nullable = false, length = 60)
	private String nome;
	
	@NotNull( message = "Selecione um departamento" )
	@ManyToOne
	@JoinColumn(name = "departamento")
	private Departamento departamento;
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
