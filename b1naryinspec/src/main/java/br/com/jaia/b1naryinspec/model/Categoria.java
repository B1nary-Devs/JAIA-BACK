package br.com.jaia.b1naryinspec.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "CATEGORIA")
public class Categoria {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false, name = "categoria_id")
    private Long id;

    @Column(name =  "categoria_nome" )
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "relacao_categoria_checklist",
            joinColumns = @JoinColumn(name = "categoria_id"),
            inverseJoinColumns = @JoinColumn(name = "checklist_id"))
    private List<Checklist> checklistList;
    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
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

    public Categoria(Long id, String nome, List<Checklist> checklistList) {
        this.id = id;
        this.nome = nome;
        this.checklistList = checklistList;
    }

    public List<Checklist> getChecklistList() {
        return checklistList;
    }

    public void setChecklistList(List<Checklist> checklistList) {
        this.checklistList = checklistList;
    }
}
