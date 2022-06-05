package br.com.fernando.clinica.consulta.repository;

import br.com.fernando.clinica.consulta.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
