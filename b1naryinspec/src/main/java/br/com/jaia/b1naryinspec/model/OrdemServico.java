package br.com.jaia.b1naryinspec.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class OrdemServico {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ordem_servico_id")
    @Id
    private Long servicoId;

    @Column(name =  "data_abertura" )
    private LocalDateTime dataAbertura;

    @Column(name =  "data_fechamento" )
    private LocalDateTime dataFechamento;

    @Column(name =  "status" )
    private String status;


    @Column(name = "descricao")
    private String descricao;


//    @Column(name =  "cliente_id", unique = true )
//    @OneToMany(mappedBy = "cliente_id", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    private Set<Cliente> cliente;


    public OrdemServico(Long servicoId, LocalDateTime dataAbertura, LocalDateTime dataFechamento, String status, String descricao) {
        this.servicoId = servicoId;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.descricao = descricao;
    }

    public OrdemServico() {
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
