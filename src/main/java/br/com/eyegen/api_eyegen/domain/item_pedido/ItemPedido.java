package br.com.eyegen.api_eyegen.domain.item_pedido;


import br.com.eyegen.api_eyegen.domain.pedido.enums.MetodoPagamento;
import br.com.eyegen.api_eyegen.domain.pedido.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "item_pedidos")
@Entity(name = "ItemPedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // vai ser modificado com as relações

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;

    private Integer quantidade;
}