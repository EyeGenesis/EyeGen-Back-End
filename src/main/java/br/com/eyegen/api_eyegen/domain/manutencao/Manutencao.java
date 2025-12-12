package br.com.eyegen.api_eyegen.domain.manutencao;

import br.com.eyegen.api_eyegen.domain.dispositivo.Dispositivo;
import br.com.eyegen.api_eyegen.domain.manutencao.enums.StatusManutencao;
import br.com.eyegen.api_eyegen.domain.manutencao.enums.TipoManutencao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "manutencao")
@Entity(name = "Manutencao")
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manutencao")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private TipoManutencao manutencao;

    @Column(name = "descricao_problema")
    private String descricaoProblema;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_manutencao")
    private StatusManutencao statusManutencao;

    @Column(name = "data_solicitacao")
    private LocalDateTime dataSolicitacao;

    @ManyToOne
    @JoinColumn(name = "id_dispositivo")
    private Dispositivo dispositivo;
}
