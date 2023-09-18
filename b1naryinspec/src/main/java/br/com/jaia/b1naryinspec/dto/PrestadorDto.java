package br.com.jaia.b1naryinspec.dto;



public class PrestadorDto {
   
    private Long prestador_id;
    private String cnpj;
    private String email;
    private String senha;
    private String prestador_nome;
    private Long categoria_id;

    public Long getPrestador_id() {
        return prestador_id;
    }

    public void setPrestador_id(Long prestador_id) {
        this.prestador_id = prestador_id;
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

}
