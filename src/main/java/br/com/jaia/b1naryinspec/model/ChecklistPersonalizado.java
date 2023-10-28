package br.com.jaia.b1naryinspec.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "checklist_personalizado")
public class ChecklistPersonalizado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_personalizado_id")
    private Long checklistPersonalizadoId;

    @Column(name = "checklist_personalizado_nome", nullable = false)
    private String checklistPersonalizadoNome;

    @Column(name = "checklist_personalizado_observacao")
    private String observacao;

    @Column(name = "checklist_personalizado_situacao")
    private String situacao;


    @ManyToOne
    @JoinColumn(name = "ordem_servico_id")
    @JsonIgnore
    private OrdemServico ordemServico;

    @ManyToOne
    @JoinColumn(name = "segmento_id")
    private Segmento segmento;

    public ChecklistPersonalizado(Long checklistPersonalizadoId, String checklistPersonalizadoNome, String observacao, String situacao, OrdemServico ordemServico, Segmento segmento) {
        this.checklistPersonalizadoId = checklistPersonalizadoId;
        this.checklistPersonalizadoNome = checklistPersonalizadoNome;
        this.observacao = observacao;
        this.situacao = situacao;
        this.ordemServico = ordemServico;
        this.segmento = segmento;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String descricao) {
        this.observacao = descricao;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
