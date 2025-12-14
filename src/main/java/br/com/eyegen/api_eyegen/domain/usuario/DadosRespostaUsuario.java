package br.com.eyegen.api_eyegen.domain.usuario;

import br.com.eyegen.api_eyegen.domain.usuario.enums.TipoDeficienciaVisual;

import java.time.LocalDate;

public record DadosRespostaUsuario(Long id, String nome, String email, TipoDeficienciaVisual tipoDeficienciaVisual, LocalDate dataNascimento, String telefone) {
    public DadosRespostaUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNomeUsuario(), usuario.getEmail(), usuario.getTipoDeficienciaVisual(), usuario.getDataNascimento(), usuario.getTelefone());
    }
}
