package br.com.jaia.b1naryinspec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
//    @Autowired
//    private UsuarioService usuario;
//
//    @Autowired
//    private UsuarioRepository usuarioRepo;
//
//    @GetMapping
//    public ResponseEntity<List<Usuario>> todosUsuarios(){
//        return ResponseEntity.status(HttpStatus.OK).body(usuario.buscarTodosUsuarios());
//    }
//
//    @GetMapping(value = "/id/{id}")
//    public ResponseEntity<Object> buscarUsuarioId(@PathVariable("id") Long usuarioId){
//        Optional<Usuario> usuarioOp = usuarioRepo.findById(usuarioId);
//        if(!usuarioOp.isPresent()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(usuario.buscarUsuarioId(usuarioId));
//    }
//
//    @PostMapping
//    public ResponseEntity<Usuario> novoUsuario(@RequestBody UsuarioDTO usuarioDTO){
//        return ResponseEntity.status(HttpStatus.CREATED).body(usuario.novoUsuario(usuarioDTO));
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Object> editarUsuario(@PathVariable("id") Long usuarioId, @RequestBody UsuarioDTO usuarioDTO){
//        Optional<Usuario> usuarioOp = usuarioRepo.findById(usuarioId);
//        if(!usuarioOp.isPresent()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(usuario.updateUsuario(usuarioId, usuarioDTO));
//    }

}
