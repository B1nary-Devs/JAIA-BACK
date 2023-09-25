package br.com.jaia.b1naryinspec.dto;

import br.com.jaia.b1naryinspec.model.Checklist;

import java.util.ArrayList;
import java.util.List;


public class ChecklistDTO {

    private Long checklistId;


    private String checklistNome;




    private List<CategoriaDTO> categorias = new ArrayList<>();



    public ChecklistDTO() {
    }





    public ChecklistDTO(Checklist entity) {
        this.checklistId = entity.getChecklistId();
        this.checklistNome = entity.getChecklistNome();
        entity.getCategorias().forEach(cat -> this.categorias.add(new CategoriaDTO(cat)));
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

    public List<CategoriaDTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaDTO> categorias) {
        this.categorias = categorias;
    }








}
