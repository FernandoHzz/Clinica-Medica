package br.com.fernando.clinica.consulta.service;

import br.com.fernando.clinica.consulta.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    @Autowired
    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

}
