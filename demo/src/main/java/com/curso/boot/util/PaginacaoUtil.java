package com.curso.boot.util;

import java.util.List;

public class PaginacaoUtil<T> {
	private int tamanho;
	private int pagina;
	private long totalDePaginas;
	private List<T> registros;
	
	public int getTamanho() {
		return tamanho;
	}

	public int getPagina() {
		return pagina;
	}

	public long getTotalDePaginas() {
		return totalDePaginas;
	}

	public List<T> getRegistros() {
		return registros;
	}

	public PaginacaoUtil(int tamanho, int pagina, long totalDePaginas2, List<T> registros) {
		super();
		this.tamanho = tamanho;
		this.pagina = pagina;
		this.totalDePaginas = totalDePaginas2;
		this.registros = registros;
	}
}
