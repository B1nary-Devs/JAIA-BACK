package br.com.jaia.b1naryinspec.dto;

import br.com.jaia.b1naryinspec.model.Segmento;
import br.com.jaia.b1naryinspec.model.Usuario;

public class PrestadorGetDTO {


    private Long prestadorId;
    private String cnpj;
    private String prestadorNome;
    private Segmento segmento;
    private Usuario usuario;

    public PrestadorGetDTO(Long prestadorId, String cnpj, String prestadorNome, Segmento segmento, Usuario usuario) {
        this.prestadorId = prestadorId;
        this.cnpj = cnpj;
        this.prestadorNome = prestadorNome;
        this.segmento = segmento;
        this.usuario = usuario;
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
