package br.com.jaia.b1naryinspec.dto;

import br.com.jaia.b1naryinspec.model.OrdemServico;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


public class OrdemServicoDTO {

    private Long servicoId;

    @JsonFormat(pattern = "dd/MM/yyyy  HH:mm:ss")
    private LocalDateTime dataAbertura = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy  HH:mm:ss")
    private LocalDateTime dataFechamento;

    private String status;

    private String descricao;

    private Long cliente;

    private List<Long> prestadores;

    private List<Long> checklists;

    private Long solicitacao;


    public OrdemServicoDTO(Long servicoId, LocalDateTime dataAbertura, LocalDateTime dataFechamento, String status, String descricao, Long cliente, List<Long> prestadores, List<Long> checklists, Long solicitacao) {
        this.servicoId = servicoId;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.descricao = descricao;
        this.cliente = cliente;
        this.prestadores = prestadores;
        this.checklists = checklists;
        this.solicitacao = solicitacao;
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

    public List<Long> getPrestadores() {
        return prestadores;
    }

    public void setPrestadores(List<Long> prestadores) {
        this.prestadores = prestadores;
    }

    public List<Long> getChecklists() {
        return checklists;
    }

    public void setChecklists(List<Long> checklists) {
        this.checklists = checklists;
    }


    public Long getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Long solicitacao) {
        this.solicitacao = solicitacao;
    }
}
