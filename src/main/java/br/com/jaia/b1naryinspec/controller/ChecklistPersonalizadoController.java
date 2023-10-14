package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.dto.ChecklistPersonalizadoDTO;
import br.com.jaia.b1naryinspec.model.ChecklistPersonalizado;
import br.com.jaia.b1naryinspec.service.ChecklistPersonalizadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/checklist_personalizado")


public class ChecklistPersonalizadoController {

    final ChecklistPersonalizadoService checklistPersonalizadoService;


    public ChecklistPersonalizadoController(ChecklistPersonalizadoService checklistPersonalizadoService) {
        this.checklistPersonalizadoService = checklistPersonalizadoService;
    }


    @PostMapping
    public ResponseEntity<Object> saveChecklistPersonalizado(@RequestBody ChecklistPersonalizadoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(checklistPersonalizadoService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ChecklistPersonalizado>> getAllChecklistPersonalizados() {
        return ResponseEntity.status(HttpStatus.OK).body(checklistPersonalizadoService.findAll());
    }


}
