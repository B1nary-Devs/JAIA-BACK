package br.com.jaia.b1naryinspec.dto;

import br.com.jaia.b1naryinspec.model.Segmento;

public class SolicitacaoDTO {
    
    private Long solicitacaoId;
    private String descricao;
    private String resultado;
    private String nomeEmpresa;
    private String cnpj;

    private Long segmento;


    public SolicitacaoDTO(){

    }

    public SolicitacaoDTO(Long solicitacaoId, String descricao, String resultado, String nomeEmpresa, String cnpj, Long segmento) {
        this.solicitacaoId = solicitacaoId;
        this.descricao = descricao;
        this.resultado = resultado;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.segmento = segmento;
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public Long getSegmento() {
        return segmento;
    }

    public void setSegmento(Long segmento) {
        this.segmento = segmento;
    }


}
