package br.com.eyegen.api_eyegen.domain.pedido;

import br.com.eyegen.api_eyegen.domain.item_pedido.DadosItemPedido;
import br.com.eyegen.api_eyegen.domain.pedido.enums.MetodoPagamento;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosRealizaPedido(
        @NotNull(message = "O método de pagamento é obrigatório")
        MetodoPagamento metodoPagamento,

        @NotNull(message = "O id do usuário deve")
        Long idUsuario,

        @NotEmpty(message = "Um pedido deve ter no mínimo um item")
        List<DadosItemPedido> itens
) {
}
