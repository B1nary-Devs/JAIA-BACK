package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.dto.ChecklistDTO;
import br.com.jaia.b1naryinspec.dto.OrdemServicoDTO;
import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.model.OrdemServico;
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
    public ResponseEntity<List<Checklist>> findAll() {
        List<Checklist> dtos = checklistService.findAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ChecklistDTO> insert(@Valid @RequestBody ChecklistDTO dto){
        dto = checklistService.salvar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getChecklistId()).toUri();


        return ResponseEntity.created(uri).body(dto);

    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> editarChecklist(@PathVariable("id") Long id, @RequestBody ChecklistDTO dto ){

        Checklist ordemOp = checklistService.findById(id);
        if(ordemOp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checklist não encontrado");
        }

        dto.setChecklistId(id);

        return ResponseEntity.status(HttpStatus.OK).body(checklistService.salvar(dto));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        checklistService.excluir(id);
        return ResponseEntity.noContent().build();
    }








}
