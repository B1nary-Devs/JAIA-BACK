package br.com.jaia.b1naryinspec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jaia.b1naryinspec.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
    
