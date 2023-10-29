package br.com.jaia.b1naryinspec.dto;

public class ClienteDTO {
    
    private Long clienteId;
    private String clienteCnpj;
    private String clienteNome;

    public ClienteDTO(Long clienteId, String clienteCnpj, String clienteNome) {
        this.clienteId = clienteId;
        this.clienteCnpj = clienteCnpj;
        this.clienteNome = clienteNome;
    }

    public ClienteDTO() {
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteCnpj() {
        return clienteCnpj;
    }

    public void setClienteCnpj(String clienteCnpj) {
        this.clienteCnpj = clienteCnpj;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

}
