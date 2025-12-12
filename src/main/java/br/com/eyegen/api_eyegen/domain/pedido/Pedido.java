package br.com.eyegen.api_eyegen.domain.pedido;

import br.com.eyegen.api_eyegen.domain.pedido.enums.MetodoPagamento;
import br.com.eyegen.api_eyegen.domain.pedido.enums.StatusPedido;
import br.com.eyegen.api_eyegen.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
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
}
