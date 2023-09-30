package br.com.jaia.b1naryinspec.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDTO {

    private Long servicoId;


    private LocalDateTime dataAbertura;

    private LocalDateTime dataFechamento;


    private String status;




    private List<ClienteDTO> clientes = new ArrayList<>();


    //TO DO FAZER A LIS DE CLIENTESDTO PRA ORDER DE SERVICODTO
    public OrdemServicoDTO(Long servicoId, LocalDateTime dataAbertura, LocalDateTime dataFechamento, String status, List<ClienteDTO> clientes) {
        this.servicoId = servicoId;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.clientes = clientes; // AQUI
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

    public List<ClienteDTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteDTO> clientes) {
        this.clientes = clientes;
    }





}
