package br.com.jaia.b1naryinspec.model;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_id")
    private PrestadorServico prestadorServicos;

    public Usuario(Long usuarioId, String email, String senha, String acesso, PrestadorServico prestadorServicos) {
        this.usuarioId = usuarioId;
        this.email = email;
        this.senha = senha;
        this.acesso = acesso;
        this.prestadorServicos = prestadorServicos;
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

    public Usuario(PrestadorServico prestadorServicos) {
        this.prestadorServicos = prestadorServicos;
    }


    public PrestadorServico getPrestadorServicos() {
        return prestadorServicos;
    }

    public void setPrestadorServicos(PrestadorServico prestadorServicos) {
        this.prestadorServicos = prestadorServicos;
    }


}
