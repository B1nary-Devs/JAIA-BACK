package br.com.jaia.b1naryinspec.controller;



import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.service.ChecklistService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<Checklist>> findAllChecklists() {
        List<Checklist> checklists = checklistService.findAll();
        return ResponseEntity.ok(checklists);
    }







    @PostMapping
    public ResponseEntity<Checklist> insert(@Valid @RequestBody Checklist dto){
        dto = checklistService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getChecklistId()).toUri();


        return ResponseEntity.created(uri).body(dto);


    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        checklistService.delete(id);
        return ResponseEntity.noContent().build();
    }








}
