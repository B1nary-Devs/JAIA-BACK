package br.com.jaia.b1naryinspec.model;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "acesso")
    @Enumerated(EnumType.STRING)
    private UserRole role;


    @OneToOne(mappedBy = "usuario", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnore
    private PrestadorServico prestadorServico;

    public Usuario(Long usuarioId, String email, String senha, UserRole role, PrestadorServico prestadorServico) {
        this.usuarioId = usuarioId;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.prestadorServico = prestadorServico;
    }

    public Usuario(Long usuarioId, String email, String senha, UserRole role) {
        this.usuarioId = usuarioId;
        this.email = email;
        this.senha = senha;
        this.role = role;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }





    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public PrestadorServico getPrestadorServico() {
        return prestadorServico;
    }

    public void setPrestadorServico(PrestadorServico prestadorServico) {
        this.prestadorServico = prestadorServico;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}











