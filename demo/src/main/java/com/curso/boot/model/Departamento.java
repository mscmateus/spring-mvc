package com.curso.boot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.curso.boot.model.Cargo;

@SuppressWarnings("serial")
@Entity
@Table(name = "Departmento")
public class Departamento extends AbstractEntity<Long> {
	@NotNull(message = "Informe um nome")
	@Size(min = 3, max= 60, message = "O nome do departamento deve ter entre {min} e {max} caracteres!")
	@Column(nullable = false, length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "departamento")	
	private List<Cargo> cargos;

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
}
