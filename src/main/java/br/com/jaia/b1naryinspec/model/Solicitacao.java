package br.com.jaia.b1naryinspec.model;


import jakarta.persistence.*;



@Entity
@Table(name = "solicitacao")
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "solicitacao_id")
    private Long solicitacaoId;

    @Column(name = "descricao_solicitacao")
    private String descricao;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "nome_empresa")
    private String nomeEmpresa;

    @Column(name = "cnpj_empresa")
    private String cnpj;


    @ManyToOne
    @JoinColumn(name = "segmento_id")
    private Segmento segmento;


    @ManyToOne
    @JoinColumn(name = "ordem_de_servico_id")
    private OrdemServico ordemServico;


    public Solicitacao(Long solicitacaoId, String descricao, String resultado, String nomeEmpresa, String cnpj, Segmento segmento, OrdemServico ordemServico) {
        this.solicitacaoId = solicitacaoId;
        this.descricao = descricao;
        this.resultado = resultado;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.segmento = segmento;
        this.ordemServico = ordemServico;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }



    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }






}
