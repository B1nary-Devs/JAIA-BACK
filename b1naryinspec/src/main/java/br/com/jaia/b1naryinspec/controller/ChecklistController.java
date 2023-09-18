package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.service.ChecklistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.jaia.b1naryinspec.model.Checklist;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/checklist")
@CrossOrigin
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
    public ResponseEntity<Object> novoChecklist(@RequestBody Checklist checklist) {
        return ResponseEntity.status(HttpStatus.CREATED).body(checklistService.salvar(checklist));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        Checklist checklistOptional = checklistService.findByChecklistId(id);
        if (checklistOptional == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checklist não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(checklistOptional);
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Object> buscarPorNome(@PathVariable("nome") String nome) {
        Checklist checklistOptional = checklistService.findByChecklistNome(nome);
        if (checklistOptional == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checklist não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(checklistOptional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateChecklist(@PathVariable(value = "id") Long id,
                                                  @RequestBody Checklist checklist){
        Checklist checklistOptional = checklistService.findByChecklistId(id);
        if (checklistOptional == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        checklist.setChecklistId(id);
        return ResponseEntity.status(HttpStatus.OK).body(checklistService.salvar(checklist));
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
