package br.com.eyegen.api_eyegen.repository;

import br.com.eyegen.api_eyegen.domain.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
