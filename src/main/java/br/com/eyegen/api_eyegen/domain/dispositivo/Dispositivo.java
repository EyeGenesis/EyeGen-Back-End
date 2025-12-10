package br.com.eyegen.api_eyegen.domain.dispositivo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dispositivos")
@Entity(name = "Dispositivo")
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_serie")
    private String numeroSerie;

    @Column(name = "modelo_cor")
    private String modeloCor;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_dispositivo")
    private StatusDispositivo statusDispositivo;
}
