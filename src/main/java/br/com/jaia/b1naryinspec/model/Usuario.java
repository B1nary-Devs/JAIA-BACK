package br.com.jaia.b1naryinspec.model;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

    @Override
    public boolean isEnabled() {
        return true;
    }



    // Padrão Builder
    public static class UsuarioBuilder {
        private Long usuarioId;
        private String email;
        private String senha;
        private UserRole role;

        public static UsuarioBuilder builder() {
            return new UsuarioBuilder();
        }

        public UsuarioBuilder withUsuarioId(Long usuarioId) {
            this.usuarioId = usuarioId;
            return this;
        }

        public UsuarioBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UsuarioBuilder withSenha(String senha) {
            this.senha = senha;
            return this;
        }

        public UsuarioBuilder withRole(UserRole role) {
            this.role = role;
            return this;
        }

        public Usuario build() {
            Usuario usuario = new Usuario();
            usuario.usuarioId = this.usuarioId;
            usuario.email = this.email;
            usuario.senha = this.senha;
            usuario.role = this.role;
            return usuario;
        }
    }












}











