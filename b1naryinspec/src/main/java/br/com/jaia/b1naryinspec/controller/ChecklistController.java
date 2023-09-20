package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.service.ChecklistService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.jaia.b1naryinspec.model.Checklist;
import java.util.List;

@RestController
@RequestMapping(value = "/checklist")
@CrossOrigin
public class ChecklistController {

    private final ChecklistService checklistService;

    public ChecklistController(ChecklistService checklistService) {
        this.checklistService = checklistService;
    }

    @GetMapping
    public List<Checklist> findAll(){
        return checklistService.findAll();
    }

}
