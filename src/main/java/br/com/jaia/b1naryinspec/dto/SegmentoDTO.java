package br.com.jaia.b1naryinspec.dto;

import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.model.Segmento;

import java.util.ArrayList;
import java.util.List;


public class SegmentoDTO {

    private Long id;
    private String nome;


    private List<ChecklistGetDTO> checklistList= new ArrayList<>();

    public SegmentoDTO() {
    }


    public SegmentoDTO(Long id, String nome, List<ChecklistGetDTO> checklistList) {
        this.id = id;
        this.nome = nome;
        this.checklistList = checklistList;
    }

    public SegmentoDTO(Segmento entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        entity.getChecklistList().forEach(cat -> this.checklistList.add(new ChecklistGetDTO(cat)));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<ChecklistGetDTO> getChecklistList() {
        return checklistList;
    }

    public void setChecklistList(List<ChecklistGetDTO> checklistList) {
        this.checklistList = checklistList;
    }
}
