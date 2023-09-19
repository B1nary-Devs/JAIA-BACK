package br.com.jaia.b1naryinspec.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "checklist")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_id")
    private Long checklistId;

    @Column(name = "checklist_nome", nullable = false)
    private String checklistNome;


    @ManyToMany(mappedBy = "checklistList")

    private List<Categoria> categoriaList;

    public Checklist(Long checklistId, String checklistNome, List<Categoria> categoriaList) {
        this.checklistId = checklistId;
        this.checklistNome = checklistNome;
        this.categoriaList = categoriaList;
    }

    public Checklist(){
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

    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }
}
