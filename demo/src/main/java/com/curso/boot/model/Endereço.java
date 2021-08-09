package com.curso.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Endereco")
public class Endereço extends AbstractEntity<Long> {
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false, length = 5)
	private int number;
	
	@Column(nullable = false)
	private String district;
	
	@Column(name = "zip_code", nullable = false, length = 9)
	private String zipCode;
	
	@Column(name = "public_place", nullable = false)
	private String publicPacle;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 2)
	private UF uf;
	
	private String complement;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPublicPacle() {
		return publicPacle;
	}

	public void setPublicPacle(String publicPacle) {
		this.publicPacle = publicPacle;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
}
