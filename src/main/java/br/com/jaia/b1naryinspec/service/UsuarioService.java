package br.com.jaia.b1naryinspec.service;




import org.springframework.stereotype.Service;



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
        usuario.setAcesso(usuarioDTO.getAcesso());

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
        usuario.setAcesso(usuarioDTO.getAcesso());


        return usuarioRepo.save(usuario);
    }

}
