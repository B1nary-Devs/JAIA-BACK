package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.dto.ChecklistPersonalizadoDTO;
import br.com.jaia.b1naryinspec.dto.OrdemServicoDTO;
import br.com.jaia.b1naryinspec.model.ChecklistPersonalizado;
import br.com.jaia.b1naryinspec.model.Cliente;
import br.com.jaia.b1naryinspec.model.OrdemServico;
import br.com.jaia.b1naryinspec.service.ChecklistPersonalizadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Object> bucarIdChecklist(@PathVariable("id") Long id){
        Optional<ChecklistPersonalizado> checklistop = Optional.ofNullable(checklistPersonalizadoService.findByChecklistPersonalizadoId(id));
        if(!checklistop.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checklist personalizado não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(checklistop);
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> editarcheck(@PathVariable("id") Long id, @RequestBody ChecklistPersonalizadoDTO dto ){

        ChecklistPersonalizado check = checklistPersonalizadoService.findByChecklistPersonalizadoId(id);
        if(check == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checklist personalizado não encontrado!");
        }

        dto.setChecklistPersonalizadoId(id);

        return ResponseEntity.status(HttpStatus.OK).body(checklistPersonalizadoService.salvar(dto));
    }

}
