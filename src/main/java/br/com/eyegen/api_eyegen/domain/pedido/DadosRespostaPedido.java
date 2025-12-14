package br.com.eyegen.api_eyegen.domain.pedido;

import br.com.eyegen.api_eyegen.domain.item_pedido.DadosItemResposta;
import br.com.eyegen.api_eyegen.domain.item_pedido.ItemPedido;
import br.com.eyegen.api_eyegen.domain.pedido.enums.MetodoPagamento;
import br.com.eyegen.api_eyegen.domain.pedido.enums.StatusPedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public record DadosRespostaPedido(BigDecimal valorTotal,
                                  StatusPedido statusPedido,
                                  MetodoPagamento metodoPagamento,
                                  Long idUsuario,
                                  List<DadosItemResposta> itens) {
    public DadosRespostaPedido(Pedido pedido){
        this(pedido.getValorTotal(), pedido.getStatusPedido(), pedido.getMetodoPagamento(), pedido.getCliente().getId(), pedido.getItens().stream().map(DadosItemResposta::new).toList());

    }
}
