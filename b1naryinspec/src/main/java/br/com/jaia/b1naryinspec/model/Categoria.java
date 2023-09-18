package br.com.jaia.b1naryinspec.model;

import jakarta.persistence.*;


import java.io.Serializable;


@Entity
@Table(name = "CATEGORIA_NOME")
public class Categoria implements Serializable {

    private final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false, name = "CAT_ID")
    private Long id;

    @Column(name =  "nome" )
    private String nome;



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




}
