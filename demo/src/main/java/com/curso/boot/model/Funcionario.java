package com.curso.boot.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Employee")
public class Funcionario extends AbstractEntity<Long> {
	@Column(nullable = false, length = 60 )
	private String name;
	
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private double salary;
	
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate entry_date;
	
	@Column(columnDefinition = "DATE")
	private LocalDate departure_date;
	
	@ManyToOne
	@JoinColumn(name = "office")
	private Cargo office;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private Endereço address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(LocalDate entry_date) {
		this.entry_date = entry_date;
	}

	public LocalDate getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(LocalDate departure_date) {
		this.departure_date = departure_date;
	}

	public Cargo getOffice() {
		return office;
	}

	public void setOffice(Cargo office) {
		this.office = office;
	}

	public Endereço getAddress() {
		return address;
	}

	public void setAddress(Endereço address) {
		this.address = address;
	}
}
