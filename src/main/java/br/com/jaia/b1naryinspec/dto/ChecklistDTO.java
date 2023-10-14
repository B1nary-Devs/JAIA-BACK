package br.com.jaia.b1naryinspec.dto;

import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.model.Segmento;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ChecklistDTO {

    private Long checklistId;


    private String checklistNome;

    private List<SegmentoDTO> segmentos = new ArrayList<>();


    public ChecklistDTO() {
    }


    public ChecklistDTO(Checklist entity) {
        this.checklistId = entity.getChecklistId();
        this.checklistNome = entity.getChecklistNome();
        entity.getSegmentos().forEach(cat -> this.segmentos.add(new SegmentoDTO(cat)));
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

    public List<SegmentoDTO> getSegmentos() {
        return segmentos;
    }

    public void setSegmentos(List<SegmentoDTO> segmentos) {
        this.segmentos = segmentos;
    }
}
