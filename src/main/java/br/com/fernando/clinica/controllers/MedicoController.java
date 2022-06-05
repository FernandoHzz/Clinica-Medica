package br.com.fernando.clinica.controllers;

import br.com.fernando.clinica.medico.model.Medico;
import br.com.fernando.clinica.medico.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/medico")
public class MedicoController {

        private final MedicoService service;

        @Autowired
        public MedicoController(MedicoService service) {
            this.service = service;
        }

        @PostMapping("/cadastrar")
        public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(medico));
        }

        @GetMapping
        public ResponseEntity<List<Medico>> obterTodosMedicos() {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Object> obterMedicoPeloId(@PathVariable(value = "id") Long id) {

            Optional<Medico> medicoOptional = service.findById(id);

            if (medicoOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico com o id: " + id + " não encontrado!");
            }
            return ResponseEntity.status(HttpStatus.OK).body(medicoOptional.get());
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Object> deletarMedicoPeloCpf(@PathVariable(value = "id") Long id) {
            Optional<Medico> medicoOptional = service.findById(id);
            if (medicoOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não escontrado!.");
            }
            service.delete(medicoOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Medico deletado com sucesso");
        }

        @PutMapping("/update")
        public ResponseEntity<Medico> updateMedico(@RequestBody Medico medico) {
            Medico medicoParaAtualizar = service.update(medico);
            return new ResponseEntity<>(medicoParaAtualizar, HttpStatus.OK);
        }
    }

