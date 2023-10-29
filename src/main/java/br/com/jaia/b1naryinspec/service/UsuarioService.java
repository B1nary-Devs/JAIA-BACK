package br.com.jaia.b1naryinspec.service;




import br.com.jaia.b1naryinspec.dto.UsuarioDTO;
import br.com.jaia.b1naryinspec.model.Usuario;
import br.com.jaia.b1naryinspec.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Transactional
    public Usuario novoUsuario(UsuarioDTO usuarioDTO){
        if(usuarioDTO == null){
            throw new IllegalArgumentException("Dados inválidos!");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());

        return usuarioRepo.save(usuario);
    }

    @Transactional
    public List<Usuario> buscarTodosUsuarios(){
        return usuarioRepo.findAll();
    }

    @Transactional
    public Usuario buscarUsuarioId(Long usuarioId){
        Optional<Usuario> usuarioOp = usuarioRepo.findById(usuarioId);
        if(usuarioOp.isEmpty()){
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
        return usuarioOp.get();
    }

    @Transactional
    public Usuario updateUsuario(Long usuarioId, UsuarioDTO usuarioDTO){
        Optional<Usuario> usuarioOp = usuarioRepo.findById(usuarioId);
        if(usuarioOp.isEmpty()){
            throw new IllegalArgumentException("Usuário não encontrado!");
        }

        Usuario usuario = usuarioOp.get();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());



        return usuarioRepo.save(usuario);
    }

}
