package com.curso.boot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.curso.boot.model.Cargo;

@SuppressWarnings("serial")
@Entity
@Table(name = "Departmento")
public class Departamento extends AbstractEntity<Long> {
	@Column(nullable = false, length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "departmento")	
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
