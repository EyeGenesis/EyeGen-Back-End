package br.com.eyegen.api_eyegen.domain.usuario;

import br.com.eyegen.api_eyegen.domain.usuario.enums.TipoDeficienciaVisual;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "usuarios")
@Entity(name = "Usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    private String email;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String senha;
    private String telefone;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo_def_visual")
    private TipoDeficienciaVisual deficienciaVisual;
}
