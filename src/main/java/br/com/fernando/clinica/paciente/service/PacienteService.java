package br.com.fernando.clinica.paciente.service;

import br.com.fernando.clinica.paciente.model.Paciente;
import br.com.fernando.clinica.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    @Autowired
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Paciente save(Paciente paciente) {
        paciente.gerarDataCadastro();
        return repository.save(paciente);
    }

    public List<Paciente> findAll() { return repository.findAll(); }

    public Optional<Paciente> findById(Long id) { return repository.findById(id); }

    @Transactional
    public void delete(Paciente paciente) {
        repository.delete(paciente);
    }

    public Paciente update(Paciente paciente) {
        return repository.save(paciente);
    }

}
