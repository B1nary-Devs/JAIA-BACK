package br.com.jaia.b1naryinspec.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "checklist")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_id")
    private Long checklistId;

    @Column(name = "checklist_nome", nullable = false)
    private String checklistNome;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinTable(name = "relacao_segmento_checklist",
            joinColumns = @JoinColumn(name = "checklist_id"),
            inverseJoinColumns = @JoinColumn(name = "segmento_id"))
    @JsonManagedReference
    Set<Segmento> segmentos = new HashSet<>();





    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},mappedBy = "checklists")
    @JsonBackReference
    private Set<OrdemServico> ordemServicoList = new HashSet<>();


    public Checklist(Long checklistId, String checklistNome, Set<Segmento> segmentos, Set<OrdemServico> ordemServicoList) {
        this.checklistId = checklistId;
        this.checklistNome = checklistNome;
        this.segmentos = segmentos;
        this.ordemServicoList = ordemServicoList;
    }


    public Checklist() {
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

    public Set<Segmento> getSegmentos() {
        return segmentos;
    }

    public void setSegmentos(Set<Segmento> segmentos) {
        this.segmentos = segmentos;
    }

    public Set<OrdemServico> getOrdemServicoList() {
        return ordemServicoList;
    }

    public void setOrdemServicoList(Set<OrdemServico> ordemServicoList) {
        this.ordemServicoList = ordemServicoList;
    }




}
