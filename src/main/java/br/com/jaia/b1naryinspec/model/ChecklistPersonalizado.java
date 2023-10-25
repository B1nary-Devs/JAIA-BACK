package br.com.jaia.b1naryinspec.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "checklist_personalizado")
public class ChecklistPersonalizado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_personalizado_id")
    private Long checklistPersonalizadoId;

    @Column(name = "checklist_personalizado_nome", nullable = false)
    private String checklistPersonalizadoNome;

    @Column(name = "checklist_personalizado_descricao")
    private String descricao;


    @ManyToOne
    @JoinColumn(name = "ordem_servico_id")
    @JsonIgnore
    private OrdemServico ordemServico;

    public ChecklistPersonalizado(Long checklistPersonalizadoId, String checklistPersonalizadoNome, String descricao, OrdemServico ordemServico) {
        this.checklistPersonalizadoId = checklistPersonalizadoId;
        this.checklistPersonalizadoNome = checklistPersonalizadoNome;
        this.descricao = descricao;
        this.ordemServico = ordemServico;
    }

    public ChecklistPersonalizado() {
    }

    public Long getChecklistPersonalizadoId() {
        return checklistPersonalizadoId;
    }

    public void setChecklistPersonalizadoId(Long checklistPersonalizadoId) {
        this.checklistPersonalizadoId = checklistPersonalizadoId;
    }

    public String getChecklistPersonalizadoNome() {
        return checklistPersonalizadoNome;
    }

    public void setChecklistPersonalizadoNome(String checklistPersonalizadoNome) {
        this.checklistPersonalizadoNome = checklistPersonalizadoNome;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
