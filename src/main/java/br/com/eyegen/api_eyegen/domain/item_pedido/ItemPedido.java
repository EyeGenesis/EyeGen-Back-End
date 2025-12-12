package br.com.eyegen.api_eyegen.domain.item_pedido;

import br.com.eyegen.api_eyegen.domain.pedido.Pedido;
import br.com.eyegen.api_eyegen.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "item_pedidos")
@Entity(name = "ItemPedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;

    private Integer quantidade;

    public BigDecimal getSubTotal(){
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}