package br.com.eyegen.api_eyegen.domain.assinatura;

import br.com.eyegen.api_eyegen.domain.assinatura.enums.Plano;
import br.com.eyegen.api_eyegen.domain.assinatura.enums.StatusAssinatura;
import br.com.eyegen.api_eyegen.domain.produto.Produto;
import br.com.eyegen.api_eyegen.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Assinatura")
@Table(name = "assinaturas")
public class Assinatura {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assinatura")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Plano plano;

    @Column(name = "valor_mensal")
    private BigDecimal valorMensal;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_vencimento")
    private LocalDateTime dataVencimento;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_assinatura")
    private StatusAssinatura statusAssinatura;

    @OneToMany(mappedBy = "assinatura")
    private List<Usuario> usuarios;

    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
}
