package br.com.jaia.b1naryinspec.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "segmento")
public class Segmento {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "segmento_id")
    private Long id;

    @Column(name =  "segmento_nome", unique = true )
    private String nome;


    @ManyToMany(mappedBy = "segmentos")
    private Set<Checklist> checklistList = new HashSet<>();

    @OneToMany(mappedBy = "segmento", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ChecklistPersonalizado> checklistPersonalizadosList = new HashSet<>();

    @OneToMany(mappedBy = "segmento", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<PrestadorServico> prestadorServicos;



    @OneToMany(mappedBy = "segmento", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Solicitacao> solicitacoes;







    public Segmento() {
    }

    public Segmento(String nome) {
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


    public Segmento(Long id, String nome, Set<Checklist> checklistList, Set<ChecklistPersonalizado> checklistPersonalizadosList, Set<PrestadorServico> prestadorServicos, Set<Solicitacao> solicitacoes) {
        this.id = id;
        this.nome = nome;
        this.checklistList = checklistList;
        this.checklistPersonalizadosList = checklistPersonalizadosList;
        this.prestadorServicos = prestadorServicos;
        this.solicitacoes = solicitacoes;
    }

    public Set<Checklist> getChecklistList() {
        return checklistList;
    }



    public void setChecklistList(Set<Checklist> checklistList) {
        this.checklistList = checklistList;
    }


    public Segmento(Set<PrestadorServico> prestadorServicos) {
        this.prestadorServicos = prestadorServicos;
    }


    public Set<PrestadorServico> getPrestadorServicos() {
        return prestadorServicos;
    }

    public void setPrestadorServicos(Set<PrestadorServico> prestadorServicos) {
        this.prestadorServicos = prestadorServicos;
    }


    public Set<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(Set<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }





}
