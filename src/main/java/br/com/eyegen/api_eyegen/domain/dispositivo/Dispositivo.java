package br.com.eyegen.api_eyegen.domain.dispositivo;

import br.com.eyegen.api_eyegen.domain.dispositivo.enums.StatusDispositivo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
