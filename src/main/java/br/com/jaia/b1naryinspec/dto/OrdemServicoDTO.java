package br.com.jaia.b1naryinspec.dto;

import br.com.jaia.b1naryinspec.model.OrdemServico;


import java.time.LocalDateTime;


public class OrdemServicoDTO {

    private Long servicoId;


    private LocalDateTime dataAbertura = LocalDateTime.now();

    private LocalDateTime dataFechamento;


    private String status;

    private String descricao;

    private Long cliente;


    public OrdemServicoDTO(Long servicoId, LocalDateTime dataAbertura, LocalDateTime dataFechamento, String status, String descricao, Long cliente) {
        this.servicoId = servicoId;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.descricao = descricao;
        this.cliente = cliente;
    }



    public OrdemServicoDTO() {
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

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }


}
