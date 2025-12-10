package br.com.eyegen.api_eyegen.domain.pedido;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosPedidoFeito(
        @NotNull
        BigDecimal valorTotal,
        @NotNull
        StatusPedido statusPedido,
        @NotNull
        @PastOrPresent(message = "A data do pedido não pode estar no futuro")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataPedido,
        @NotNull
        MetodoPagamento metodoPagamento
) {
}
