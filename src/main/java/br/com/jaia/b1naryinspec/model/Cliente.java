package br.com.jaia.b1naryinspec.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

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




    @OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<OrdemServico> ordemServicos;


    public Cliente(Long clienteId, String clienteCnpj, String clienteNome, Set<OrdemServico> ordemServicos) {
        this.clienteId = clienteId;
        this.clienteCnpj = clienteCnpj;
        this.clienteNome = clienteNome;
        this.ordemServicos = ordemServicos;
    }


    public Cliente() {
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

    public Set<OrdemServico> getOrdemServicos() {
        return ordemServicos;
    }

    public void setOrdemServicos(Set<OrdemServico> ordemServicos) {
        this.ordemServicos = ordemServicos;
    }



}
