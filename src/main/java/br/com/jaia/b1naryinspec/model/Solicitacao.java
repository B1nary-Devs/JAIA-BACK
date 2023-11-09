package br.com.jaia.b1naryinspec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "solicitacao")
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "segmento_id")
    private Long solicitacaoId;

    @Column(name = "descricao_solicitacao")
    private String descricao;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "nome_empresa")
    private String nomeEmpresa;

    @Column(name = "cnpj_empresa")
    private Long cnpj;

    public Solicitacao(Long solicitacaoId, String descricao, String resultado, String nomeEmpresa, Long cnpj){
        this.solicitacaoId = solicitacaoId;
        this.descricao = descricao;
        this.resultado = resultado;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
    }

    public Solicitacao(){
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

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    
}
