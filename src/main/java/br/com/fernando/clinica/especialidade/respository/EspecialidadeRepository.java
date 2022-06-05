package br.com.fernando.clinica.especialidade.respository;

import br.com.fernando.clinica.especialidade.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}
