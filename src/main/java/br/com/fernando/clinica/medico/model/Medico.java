package br.com.fernando.clinica.medico.model;

import br.com.fernando.clinica.especialidade.model.Especialidade;
import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 25)
    private String crm;
    @Column(unique = true, nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 255)
    private String nomeCompleto;
    @OneToOne
    private Especialidade especialidade;

}
