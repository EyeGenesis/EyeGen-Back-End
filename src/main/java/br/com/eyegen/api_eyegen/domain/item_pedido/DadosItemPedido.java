package br.com.eyegen.api_eyegen.domain.item_pedido;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DadosItemPedido(
        @NotNull(message = "O id do produto é obrigatório")
        Long idProduto,
        @NotNull
        @Min(value = 1, message = "A quantidade mínima de um item é 1")
        Integer quantidade
){
}
