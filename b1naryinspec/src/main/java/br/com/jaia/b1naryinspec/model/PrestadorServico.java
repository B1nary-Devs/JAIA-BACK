package br.com.jaia.b1naryinspec.model;

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
    @Column( name = "PRESTADOR_ID")
    private Long prestadorId;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "PRESTADOR_NOME")
    private String prestadorNome;

    @Column(name = "CATEGORIA_ID")
    private Long categoriaId;

    public PrestadorServico( String cnpj, String email, String senha, String prestadorNome, Long categoriaId){
        
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.prestadorNome = prestadorNome;
        this.categoriaId = categoriaId;
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

    public String getPrestadorNome() {
        return prestadorNome;
    }

    public void setPrestadorNome(String prestadorNome) {
        this.prestadorNome = prestadorNome;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getPrestadorId() {
        return prestadorId;
    }

    public void setPrestadorId(Long prestadorId) {
        this.prestadorId = prestadorId;
    }


}
