package br.com.jaia.b1naryinspec.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ChecklistPersonalizadoDTO {

    private Long checklistPersonalizadoId;

    private String checklistPersonalizadoNome;

    private String descricao;



    private Long ordemServicoId;

    public ChecklistPersonalizadoDTO(Long checklistPersonalizadoId, String checklistPersonalizadoNome, String descricao, Long ordemServicoId) {
        this.checklistPersonalizadoId = checklistPersonalizadoId;
        this.checklistPersonalizadoNome = checklistPersonalizadoNome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
