package br.com.jaia.b1naryinspec.dto;


import br.com.jaia.b1naryinspec.model.PrestadorServico;
import br.com.jaia.b1naryinspec.model.Segmento;

public class PrestadorDto {

    private Long prestadorId;
    private String cnpj;
    private String prestadorNome;
    private Long segmentoId;
    private Long usuarioId;

    public PrestadorDto(Long prestadorId, String cnpj, String prestadorNome, Long segmentoId, Long usuarioId) {
        this.prestadorId = prestadorId;
        this.cnpj = cnpj;
        this.prestadorNome = prestadorNome;
        this.segmentoId = segmentoId;
        this.usuarioId = usuarioId;
    }

    public PrestadorDto(PrestadorServico entity) {
        this.prestadorId = entity.getPrestadorId();
        this.cnpj = entity.getCnpj();
        this.prestadorNome = entity.getPrestadorNome();

    }

    public PrestadorDto() {
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

    public Long getSegmentoId() {
        return segmentoId;
    }

    public void setSegmentoId(Long segmentoId) {
        this.segmentoId = segmentoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }


}
