package br.com.eyegen.api_eyegen.domain.produto;

import br.com.eyegen.api_eyegen.domain.item_pedido.ItemPedido;
import br.com.eyegen.api_eyegen.domain.produto.enums.TipoProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "produtos")
@Entity(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "preco_atual")
    private BigDecimal precoAtual;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo_produto")
    private TipoProduto tipoProduto;

    @OneToMany(mappedBy = "produto")
    private Set<ItemPedido> itens = new HashSet<>();
}
