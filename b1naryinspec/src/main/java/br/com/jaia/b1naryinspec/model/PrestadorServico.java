package br.com.jaia.b1naryinspec.model;


import jakarta.persistence.*;

@Entity
@Table( name = "prestador" )
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


    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID")
    private Categoria categoria;


    public PrestadorServico(Long prestadorId, String cnpj, String email, String senha, String prestadorNome, Categoria categoria) {
        this.prestadorId = prestadorId;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.prestadorNome = prestadorNome;
        this.categoria = categoria;
    }


    public PrestadorServico() {
    }


    public Long getPrestadorId() {
        return prestadorId;
    }

    public void setPrestadorId(Long prestadorId) {
        this.prestadorId = prestadorId;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }







}
