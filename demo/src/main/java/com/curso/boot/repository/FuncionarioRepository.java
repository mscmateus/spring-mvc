package com.curso.boot.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.curso.boot.model.Funcionario;

@Repository
public class FuncionarioRepository extends AbstractRepository<Funcionario, Long> {

	public List<Funcionario> findByNome(String nome) {
		// TODO Auto-generated method stub
		return createQuery("select f from Funcionario f where f.nome like concat('%', ?1, '%') ", nome);
	}

}
