package br.com.eyegen.api_eyegen.services;

import br.com.eyegen.api_eyegen.domain.item_pedido.DadosItemPedido;
import br.com.eyegen.api_eyegen.domain.item_pedido.ItemPedido;
import br.com.eyegen.api_eyegen.domain.pedido.DadosRealizaPedido;
import br.com.eyegen.api_eyegen.domain.pedido.Pedido;
import br.com.eyegen.api_eyegen.repository.PedidoRepository;
import br.com.eyegen.api_eyegen.domain.pedido.enums.StatusPedido;
import br.com.eyegen.api_eyegen.domain.produto.Produto;
import br.com.eyegen.api_eyegen.repository.ProdutoRepository;
import br.com.eyegen.api_eyegen.domain.usuario.Usuario;
import br.com.eyegen.api_eyegen.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    private ProdutoRepository produtoRepository;

    private UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Pedido realizarPedido(DadosRealizaPedido dadosPedido){

        Usuario cliente = this.usuarioRepository
                .findById(dadosPedido.idUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível encontrar o usuário pelo email"));

        Pedido pedido = new Pedido(cliente, LocalDateTime.now(), StatusPedido.PENDENTE, dadosPedido.metodoPagamento());

        List<ItemPedido> itens = new ArrayList<>();

        for(DadosItemPedido itemDto : dadosPedido.itens()){
            Produto produto = this.produtoRepository
                    .findById(itemDto.idProduto())
                    .orElseThrow(() -> new EntityNotFoundException("O produto não foi encontrado"));

            ItemPedido item = new ItemPedido(produto, pedido, itemDto.quantidade());

            item.setPrecoUnitario(produto.getPrecoAtual());

            itens.add(item);
        }

        pedido.setItens(itens);

        pedido.calculaTotal();

       return this.pedidoRepository.save(pedido);
    }
}
