package br.com.jaia.b1naryinspec.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ChecklistPersonalizadoDTO {

    private Long checklistPersonalizadoId;

    private String checklistPersonalizadoNome;

    private String observacao;

    private String situacao;

    private Long segmentoId;
    private Long ordemServicoId;

    public ChecklistPersonalizadoDTO(Long checklistPersonalizadoId, String checklistPersonalizadoNome, String observacao, String situacao, Long segmentoId, Long ordemServicoId) {
        this.checklistPersonalizadoId = checklistPersonalizadoId;
        this.checklistPersonalizadoNome = checklistPersonalizadoNome;
        this.observacao = observacao;
        this.situacao = situacao;
        this.segmentoId = segmentoId;
        this.ordemServicoId = ordemServicoId;
    }

    public ChecklistPersonalizadoDTO() {
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

    public Long getOrdemServicoId() {
        return ordemServicoId;
    }

    public void setOrdemServicoId(Long ordemServicoId) {
        this.ordemServicoId = ordemServicoId;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Long getSegmentoId() {
        return segmentoId;
    }

    public void setSegmentoId(Long segmentoId) {
        this.segmentoId = segmentoId;
    }
}
