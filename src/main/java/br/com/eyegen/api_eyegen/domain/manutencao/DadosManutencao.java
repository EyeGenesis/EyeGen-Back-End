package br.com.eyegen.api_eyegen.domain.manutencao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosManutencao(@NotNull
                              TipoManutencao manutencao,
                              @NotNull
                              StatusManutencao statusManutencao,
                              @NotBlank
                              String descricaoProblema,
                              @NotNull
                              @JsonFormat(pattern = "yyyy-MM-dd")
                              LocalDate dataSolicitacao) {
}
