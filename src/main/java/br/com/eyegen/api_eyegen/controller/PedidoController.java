package br.com.eyegen.api_eyegen.controller;

import br.com.eyegen.api_eyegen.domain.item_pedido.DadosItemResposta;
import br.com.eyegen.api_eyegen.domain.pedido.DadosRealizaPedido;
import br.com.eyegen.api_eyegen.domain.pedido.DadosRespostaPedido;
import br.com.eyegen.api_eyegen.domain.pedido.Pedido;
import br.com.eyegen.api_eyegen.domain.pedido.PedidoRepository;
import br.com.eyegen.api_eyegen.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosRealizaPedido dados){
        Pedido pedidoRealizado = this.service.realizarPedido(dados);
        var pedidoResposta = new DadosRespostaPedido(pedidoRealizado);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResposta);
    }
}
