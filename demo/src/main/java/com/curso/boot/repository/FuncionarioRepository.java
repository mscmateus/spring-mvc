package com.curso.boot.repository;

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

}
