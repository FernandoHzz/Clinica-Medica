package br.com.fernando.clinica.controllers;

import br.com.fernando.clinica.paciente.model.Paciente;
import br.com.fernando.clinica.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService service;

    @Autowired
    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> obterTodosPacientes() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterPacientePeloId(@PathVariable(value = "id") Long id) {

        Optional<Paciente> pacienteOptional = service.findById(id);

        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente com o id: " + id + " não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacienteOptional.get());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletarPacientePeloCpf(@PathVariable(value = "id") Long id) {
            Optional<Paciente> pacienteOptional = service.findById(id);
            if (pacienteOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não escontradp!.");
            }
            service.delete(pacienteOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso");
    }

    @PutMapping("/update")
    public ResponseEntity<Paciente> updatePaciente(@RequestBody Paciente paciente) {
        Paciente pacienteParaAtualizar = service.update(paciente);
        return new ResponseEntity<>(pacienteParaAtualizar, HttpStatus.OK);
    }

}
