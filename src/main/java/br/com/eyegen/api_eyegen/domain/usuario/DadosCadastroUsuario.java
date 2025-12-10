package br.com.eyegen.api_eyegen.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(@NotBlank
                                   String nome,
                                   @NotBlank
                                   @Email
                                   String email,
                                   @NotBlank
                                   String senha,
                                   @NotNull
                                   TipoDeficienciaVisual deficienciaVisual) {
}
