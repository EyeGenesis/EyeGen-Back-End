package br.com.eyegen.api_eyegen.domain.assinatura;

import br.com.eyegen.api_eyegen.domain.assinatura.enums.Plano;
import br.com.eyegen.api_eyegen.domain.assinatura.enums.StatusAssinatura;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    private LocalDate dataInicio;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Enumerated(value = EnumType.STRING)
    private StatusAssinatura status;
}
