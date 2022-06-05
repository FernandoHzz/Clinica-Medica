package br.com.fernando.clinica.medico.service;

import br.com.fernando.clinica.medico.model.Medico;
import br.com.fernando.clinica.medico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    @Autowired
    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public Medico save(Medico medico) { return repository.save(medico); }

    public List<Medico> findAll() { return repository.findAll(); }

    public Optional<Medico> findById(Long id) { return repository.findById(id); }

    @Transactional
    public void delete(Medico medico) {
        repository.delete(medico);
    }

    public Medico update(Medico medico) { return repository.save(medico); }

}


