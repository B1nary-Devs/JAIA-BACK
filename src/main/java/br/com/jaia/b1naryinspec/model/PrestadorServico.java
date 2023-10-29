package br.com.jaia.b1naryinspec.model;



import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table( name = "prestador" )
public class PrestadorServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "PRESTADOR_ID")
    private Long prestadorId;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "PRESTADOR_NOME")
    private String prestadorNome;

    @ManyToMany(mappedBy = "prestador")
    @JsonBackReference
    private Set<OrdemServico> ordemServicos = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "segmento_id")
    private Segmento segmento;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public PrestadorServico(Long prestadorId, String cnpj, String prestadorNome, Set<OrdemServico> ordemServicos, Segmento segmento, Usuario usuario) {
        this.prestadorId = prestadorId;
        this.cnpj = cnpj;
        this.prestadorNome = prestadorNome;
        this.ordemServicos = ordemServicos;
        this.segmento = segmento;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
