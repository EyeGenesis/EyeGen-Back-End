package br.com.eyegen.api_eyegen.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario(@NotBlank
                                   String nome,
                                   @NotBlank
                                   @Email
                                   String email,
                                   @NotBlank
                                   String senha,
                                   @Pattern(
                                           regexp = "^[1-9]{2}[0-9]{8,9}$",
                                           message = "Telefone inválido"
                                   )
                                   @NotBlank
                                   String telefone,
                                   @NotNull
                                   TipoDeficienciaVisual deficienciaVisual) {
}
