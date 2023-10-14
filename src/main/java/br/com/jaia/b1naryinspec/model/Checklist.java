package br.com.jaia.b1naryinspec.model;

import br.com.jaia.b1naryinspec.dto.SegmentoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
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
    @JsonIgnore
    @JoinTable(name = "relacao_segmento_checklist",
            joinColumns = @JoinColumn(name = "checklist_id"),
            inverseJoinColumns = @JoinColumn(name = "segmento_id"))
    private Set<Segmento> segmentos = new HashSet<>();

    

    public Checklist(Long checklistId, String checklistNome, Set<Segmento> segmentoList) {
        this.checklistId = checklistId;
        this.checklistNome = checklistNome;
        this.segmentos = segmentoList;
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
}
