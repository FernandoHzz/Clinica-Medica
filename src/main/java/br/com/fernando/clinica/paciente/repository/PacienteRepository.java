package br.com.fernando.clinica.paciente.repository;

import br.com.fernando.clinica.paciente.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
}
