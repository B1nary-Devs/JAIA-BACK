package br.com.jaia.b1naryinspec.dto;



public class PrestadorDto {
   
    private Long prestadorId;
    private String cnpj;
    private String email;
    private String senha;
    private String prestadorNome;
    private Long segmentoId;    
    private Long usuarioId;

    public PrestadorDto(String email, String senha, Long usuarioId, Long prestadorId, String cnpj, String prestadorNome, Long segmentoId) {
        this.email = email;
        this.senha = senha;
        this.usuarioId = usuarioId;
        this.prestadorId = prestadorId;
        this.cnpj = cnpj;
        this.prestadorNome = prestadorNome;
        this.segmentoId = segmentoId;
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

    public Long getSegmentoId() {
        return segmentoId;
    }

    public void setSegmentoId(Long segmentoId) {
        this.segmentoId = segmentoId;
    }

    public Long getUsuarioId(){
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId){
        this.usuarioId = usuarioId;
    }
}
