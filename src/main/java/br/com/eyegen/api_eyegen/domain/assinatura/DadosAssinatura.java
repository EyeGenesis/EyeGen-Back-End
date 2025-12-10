package br.com.eyegen.api_eyegen.domain.assinatura;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosAssinatura(@NotNull
                              Plano plano,
                              @NotNull(message = "A data de início é obrigatória")
                              @PastOrPresent(message = "A data de início não pode estar no futuro")
                              LocalDate dataInicio,
                              @NotNull(message = "A data de vencimento é obrigatória")
                              @Future(message = "A data de vencimento deve ser futura")
                              LocalDate dataVencimento,
                              @NotNull
                              Status status) {
}
