package br.com.eyegen.api_eyegen.domain.manutencao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "manutencao")
@Entity(name = "Manutencao")
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private TipoManutencao manutencao;

    @Column(name = "descricao_problema")
    private String descricaoProblema;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_manutencao")
    private StatusManutencao statusManutencao;

    @Column(name = "data_solicitacao")
    private LocalDate dataSolicitacao;
}
