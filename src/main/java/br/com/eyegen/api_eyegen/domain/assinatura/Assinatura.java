package br.com.eyegen.api_eyegen.domain.assinatura;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Assinatura")
@Table(name = "assinaturas")
public class Assinatura {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Status status;
}
