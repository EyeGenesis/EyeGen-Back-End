package br.com.eyegen.api_eyegen.domain.pedido;

import br.com.eyegen.api_eyegen.domain.item_pedido.ItemPedido;
import br.com.eyegen.api_eyegen.domain.pedido.enums.MetodoPagamento;
import br.com.eyegen.api_eyegen.domain.pedido.enums.StatusPedido;
import br.com.eyegen.api_eyegen.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "pedidos")
@Entity(name = "Pedido")
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_pedido")
    private StatusPedido statusPedido;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "metodo_pagamento")
    private MetodoPagamento metodoPagamento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Usuario cliente, LocalDateTime dataPedido, StatusPedido statusPedido, MetodoPagamento metodoPagamento) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.metodoPagamento = metodoPagamento;
    }

    public void calculaTotal(){
        this.valorTotal = itens.stream()
                .map(ItemPedido::getSubTotal).reduce((BigDecimal::add))
                .orElseThrow();

    }

}
