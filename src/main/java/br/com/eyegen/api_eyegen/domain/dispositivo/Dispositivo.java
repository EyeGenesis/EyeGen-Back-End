package br.com.eyegen.api_eyegen.domain.dispositivo;

import br.com.eyegen.api_eyegen.domain.dispositivo.enums.StatusDispositivo;
import br.com.eyegen.api_eyegen.domain.manutencao.Manutencao;
import br.com.eyegen.api_eyegen.domain.produto.Produto;
import br.com.eyegen.api_eyegen.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "dispositivos")
@Entity(name = "Dispositivo")
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dispositivo")
    private Long id;

    @Column(name = "numero_serie")
    private String numeroSerie;

    @Column(name = "modelo_cor")
    private String modeloCor;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_dispositivo")
    private StatusDispositivo statusDispositivo;

    @Column(name = "data_ativacao")
    private LocalDateTime dataAtivacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "dispositivo")
    private List<Manutencao> manutencoes;

    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

}
