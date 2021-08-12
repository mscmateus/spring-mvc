package com.curso.boot.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.curso.boot.model.Cargo;
import com.curso.boot.util.PaginacaoUtil;

@Repository
public class CargoRepository extends AbstractRepository<Cargo, Long> {
	public PaginacaoUtil<Cargo> buscaPaginada(int pagina){
		int tamanho = 5;
		int inicio = (pagina - 1) * tamanho;
		List<Cargo> cargos = getEntityManager()
				.createQuery("SELECT c FROM Cargo c ORDER BY c.nome asc", Cargo.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		
		long totalRegistros = count();
		long totalDePaginas = (totalRegistros + (tamanho - 1))/tamanho;
		
		return new PaginacaoUtil<Cargo>(tamanho, pagina, totalDePaginas, cargos);
	}
	
	public long count() {
		return getEntityManager().createQuery("SELECT COUNT(*) FROM Cargo", Long.class)
				.getSingleResult();
	}
}
