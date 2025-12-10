package br.com.eyegen.api_eyegen.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "usuarios")
@Entity(name = "Usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Instant data_nascimento;
    private String senha;
    private String telefone;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo_def_visual")
    private TipoDeficienciaVisual deficienciaVisual;
}
