package br.com.jaia.b1naryinspec.model;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "categoria")
public class Categoria {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false, name = "categoria_id")
    private Long id;

    @Column(name =  "categoria_nome" )
    private String nome;


    @ManyToMany(mappedBy = "categorias")
//    @JsonIgnore
    private Set<Checklist> checklistList = new HashSet<>();
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

    public Categoria(Long id, String nome, Set<Checklist> checklistList) {
        this.id = id;
        this.nome = nome;
        this.checklistList = checklistList;
    }




    public Set<Checklist> getChecklistList() {
        return checklistList;
    }

    public void setChecklistList(Set<Checklist> checklistList) {
        this.checklistList = checklistList;
    }





}
