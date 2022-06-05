package br.com.fernando.clinica.controllers;

import br.com.fernando.clinica.especialidade.model.Especialidade;
import br.com.fernando.clinica.especialidade.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeController {

    private final EspecialidadeService service;

    @Autowired
    public EspecialidadeController(EspecialidadeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Especialidade>> findall() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Especialidade>> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Especialidade> save(@RequestBody Especialidade especialidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(especialidade));
    }

}
