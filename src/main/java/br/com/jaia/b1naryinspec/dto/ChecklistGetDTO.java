package br.com.jaia.b1naryinspec.dto;

import br.com.jaia.b1naryinspec.model.Checklist;

import java.util.ArrayList;
import java.util.List;


public class ChecklistGetDTO {

    private Long checklistId;

    private String checklistNome;




    public ChecklistGetDTO() {
    }


    public ChecklistGetDTO(Long checklistId, String checklistNome) {
        this.checklistId = checklistId;
        this.checklistNome = checklistNome;
    }


    public ChecklistGetDTO(Checklist entity) {
        this.checklistId = entity.getChecklistId();
        this.checklistNome = entity.getChecklistNome();
    }

    public Long getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Long checklistId) {
        this.checklistId = checklistId;
    }

    public String getChecklistNome() {
        return checklistNome;
    }

    public void setChecklistNome(String checklistNome) {
        this.checklistNome = checklistNome;
    }
}
