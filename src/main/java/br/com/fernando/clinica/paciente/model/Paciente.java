package br.com.fernando.clinica.paciente.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String nomeCompleto;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private LocalDate dataNasc;
    @Column(nullable = false)
    private LocalDate dataCadastro;

    public void gerarDataCadastro() {
        dataCadastro = LocalDate.now();
    }

}
