package br.com.jaia.b1naryinspec.dto;

import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.model.Segmento;

import java.util.ArrayList;
import java.util.List;


public class SegmentoDTO {

    private Long id;
    private String nome;


    private List<ChecklistDTO> checklists= new ArrayList<>();

    public SegmentoDTO(Long id, String nome, List<ChecklistDTO> checklists) {
        this.id = id;
        this.nome = nome;
        this.checklists = checklists;
    }

    public SegmentoDTO() {
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

    public List<ChecklistDTO> getChecklists() {
        return checklists;
    }

    public void setChecklists(List<ChecklistDTO> checklists) {
        this.checklists = checklists;
    }
}
