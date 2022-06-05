package br.com.fernando.clinica.especialidade.service;

import br.com.fernando.clinica.especialidade.model.Especialidade;
import br.com.fernando.clinica.especialidade.respository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository repository;

    @Autowired
    public EspecialidadeService(EspecialidadeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Especialidade save(Especialidade especialidade) {
        return repository.save(especialidade);
    }

    public List<Especialidade> findAll() {
        return repository.findAll();
    }

    public Optional<Especialidade> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public void delete(Especialidade especialidade) {
        repository.delete(especialidade);
    }

    public Especialidade update(Especialidade especialidade) {
        return repository.save(especialidade);
    }

}
