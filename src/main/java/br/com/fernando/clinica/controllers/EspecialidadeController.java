package br.com.fernando.clinica.controllers;

import br.com.fernando.clinica.especialidade.model.Especialidade;
import br.com.fernando.clinica.especialidade.service.EspecialidadeService;
import br.com.fernando.clinica.medico.model.Medico;
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletarEspecialidadeById(@PathVariable(value = "id") Long id) {
        Optional<Especialidade> especialidadeOptional = service.findById(id);
        if (especialidadeOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Especialidade não escontrada!.");
        }
        service.delete(especialidadeOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Especialidade deletado com sucesso");
    }

    @PutMapping("/update")
    public ResponseEntity<Especialidade> updateEspecialidade(@RequestBody Especialidade especialidade) {
        Especialidade especialidadeParaAtualizar = service.update(especialidade);
        return new ResponseEntity<>(especialidadeParaAtualizar, HttpStatus.OK);
    }

}
