package br.com.jaia.b1naryinspec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "PRESTADOR" )
public class PrestadorServico{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRESTADOR_ID")
    private Long prestador_id;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "PRESTADOR_NOME")
    private String prestador_nome;

    @Column(name = "CATEGORIA_ID")
    private Long categoria_id;

    public PrestadorServico(String cnpj, String email, String senha, String prestador_nome, Long categoria_id){

        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.prestador_nome = prestador_nome;
        this.categoria_id = categoria_id;
    }

    public PrestadorServico(){
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPrestador_nome() {
        return prestador_nome;
    }

    public void setPrestador_nome(String prestador_nome) {
        this.prestador_nome = prestador_nome;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Long getPrestador_id() {
        return prestador_id;
    }

    public void setPrestador_id(Long prestador_id) {
        this.prestador_id = prestador_id;
    }


}
