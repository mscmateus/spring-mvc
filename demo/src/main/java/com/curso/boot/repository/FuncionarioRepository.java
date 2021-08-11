package com.curso.boot.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.curso.boot.model.Funcionario;

@Repository
public class FuncionarioRepository extends AbstractRepository<Funcionario, Long> {

	public List<Funcionario> findByNome(String nome) {
		// TODO Auto-generated method stub
		return createQuery("SELECT f FROM Funcionario f WHERE f.nome LIKE concat('%', ?1, '%') ", nome);
	}

	public List<Funcionario> findByCargoId(Long id) {
		// TODO Auto-generated method stub
		return createQuery("SELECT f FROM Funcionario f LEFT JOIN f.cargo c WHERE c.id = ?1 ", id);
	}

	public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
				.append("WHERE f.dataEntrada >= ?1 AND f.dataSaida <= ?2 ")
				.append("ORDER BY f.dataEntrada ASC").toString();
		return createQuery(jpql, entrada, saida);
	}
	
	public List<Funcionario> findByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
				.append("WHERE f.dataEntrada >= ?1 ")
				.append("ORDER BY f.dataEntrada ASC").toString();
		return createQuery(jpql, entrada);
	}
	
	public List<Funcionario> findByDataSaida( LocalDate saida) {
		String jpql = new StringBuilder("SELECT f FROM Funcionario f ")
				.append("WHERE f.dataSaida <= ?1 ")
				.append("ORDER BY f.dataEntrada ASC").toString();
		return createQuery(jpql, saida);
	}

}
