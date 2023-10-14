package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.dto.ChecklistDTO;
import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.service.ChecklistService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/checklist")
public class ChecklistController {

    private final ChecklistService checklistService;

    public ChecklistController(ChecklistService checklistService) {
        this.checklistService = checklistService;
    }


    @GetMapping
    public ResponseEntity<List<Checklist>> buscarTudo(){
        return ResponseEntity.status(HttpStatus.OK).body(checklistService.buscarTudo());
    }


    @PostMapping
    public ResponseEntity<Checklist> salvar(@RequestBody ChecklistDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(checklistService.salvar(dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteChecklist(@PathVariable(value = "id") Long id){
        Checklist checklistOptional = checklistService.findByChecklistId(id);
        if (checklistOptional == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        checklistService.delete(checklistOptional);
        return ResponseEntity.status(HttpStatus.OK).body("Checklist Deletado");
    }








}
