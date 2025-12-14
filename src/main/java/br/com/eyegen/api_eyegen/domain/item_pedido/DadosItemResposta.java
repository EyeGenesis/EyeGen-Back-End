package br.com.eyegen.api_eyegen.domain.item_pedido;

import br.com.eyegen.api_eyegen.domain.produto.Produto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosItemResposta(
        String nomeProduto,
        Integer quantidade,
        BigDecimal precoUnitario,
        BigDecimal total
){
    public DadosItemResposta(ItemPedido item){
        this(item.getProduto().getNomeProduto(), item.getQuantidade(), item.getPrecoUnitario(), item.getSubTotal());
    }
}
