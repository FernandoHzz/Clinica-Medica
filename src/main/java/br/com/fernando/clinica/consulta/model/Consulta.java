package br.com.fernando.clinica.consulta.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long idPaciente;
    @Column(nullable = false)
    private Long idMedico;
    @Column(unique = true, nullable = false)
    private LocalDateTime dataConsulta;

}
