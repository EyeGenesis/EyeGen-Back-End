package br.com.eyegen.api_eyegen.repository;

import br.com.eyegen.api_eyegen.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
