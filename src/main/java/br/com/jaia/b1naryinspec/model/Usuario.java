package br.com.jaia.b1naryinspec.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "acesso")
    private String acesso;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnore
    private PrestadorServico prestadorServico;

    public Usuario(Long usuarioId, String email, String senha, String acesso, PrestadorServico prestadorServico) {
        this.usuarioId = usuarioId;
        this.email = email;
        this.senha = senha;
        this.acesso = acesso;
        this.prestadorServico = prestadorServico;
    }

    public Usuario() {
    }

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

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public PrestadorServico getPrestadorServico() {
        return prestadorServico;
    }

    public void setPrestadorServico(PrestadorServico prestadorServico) {
        this.prestadorServico = prestadorServico;
    }
}
