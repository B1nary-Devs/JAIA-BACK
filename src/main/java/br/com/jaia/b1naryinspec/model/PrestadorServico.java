package br.com.jaia.b1naryinspec.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "prestador" )
public class PrestadorServico{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "PRESTADOR_ID")
    private Long prestadorId;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "PRESTADOR_NOME")
    private String prestadorNome;


    @ManyToMany(mappedBy = "prestador")
    @JsonBackReference
    private Set<OrdemServico> ordemServicos = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "segmento_id")
    private Segmento segmento;


    public PrestadorServico(Long prestadorId, String cnpj, String email, String senha, String prestadorNome, Set<OrdemServico> ordemServicos, Segmento segmento) {
        this.prestadorId = prestadorId;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.prestadorNome = prestadorNome;
        this.ordemServicos = ordemServicos;
        this.segmento = segmento;
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

    public Set<OrdemServico> getOrdemServicos() {
        return ordemServicos;
    }

    public void setOrdemServicos(Set<OrdemServico> ordemServicos) {
        this.ordemServicos = ordemServicos;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }



}
