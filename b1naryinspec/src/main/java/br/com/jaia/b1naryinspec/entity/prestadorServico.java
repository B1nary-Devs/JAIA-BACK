package br.com.jaia.b1naryinspec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "Prestador" )
public class PrestadorServico{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CNPJ")
    private Long cnpj;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "prestador_nome")
    private String prestador_nome;

    @Column(name = "categoria_nome")
    private String categoria_nome;

    public PrestadorServico(Long cnpj, String email, String senha, String prestador_nome, String categoria_nome){
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.prestador_nome = prestador_nome;
        this.categoria_nome = categoria_nome;
    }

    public PrestadorServico(){
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
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

    public String getCategoria_nome() {
        return categoria_nome;
    }

    public void setCategoria_nome(String categoria_nome) {
        this.categoria_nome = categoria_nome;
    }


}
