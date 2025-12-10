package br.com.eyegen.api_eyegen.domain.dispositivo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosDispositivo(@NotBlank
                               String numeroSerie,

                               @NotBlank
                               String modeloCor,

                               @NotNull
                               @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                               LocalDateTime dataAtivacao,

                               @NotNull
                               StatusDispositivo statusDispositivo) {
}
