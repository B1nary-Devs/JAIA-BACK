package br.com.jaia.b1naryinspec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "CLIENTE" )
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "CLIENTE_ID")
    private Long clienteId;

    @Column( name = "CNPJ")
    private String clienteCnpj;

    @Column( name = "NOME")
    private String clienteNome;

    public Cliente(Long clienteId, String clienteCnpj, String clienteNome){
        this.clienteId = clienteId;
        this.clienteCnpj = clienteCnpj;
        this.clienteNome = clienteNome;
    }

    public Cliente(){

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
