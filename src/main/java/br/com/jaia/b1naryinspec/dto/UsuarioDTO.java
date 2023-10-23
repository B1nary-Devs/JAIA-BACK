package br.com.jaia.b1naryinspec.dto;

public class UsuarioDTO {

    private Long usuarioId;
    private String email;
    private String senha;
    private String acesso;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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

    public String getAcesso() {
        return acesso;
    }

    public void setAceso(String acesso) {
        this.acesso = acesso;
    }
}
