package br.com.jaia.b1naryinspec.security;

import br.com.jaia.b1naryinspec.model.UserRole;
import br.com.jaia.b1naryinspec.model.Usuario;
import br.com.jaia.b1naryinspec.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
public class AuthenticationService {



    @Autowired
    private UsuarioRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public Usuario registerUser(String username, String password){

        String encodedPassword = passwordEncoder.encode(password);
        UserRole userRole = UserRole.USER;

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(userRole.name()));

        Usuario usuario = new Usuario(0L, username, encodedPassword, userRole);
        return  userRepository.save(usuario);
    }

    public LoginResponseDTO loginUser(String email, String senha){

        try {
            // Primeiro, autenticamos o usuário
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, senha)
            );

            // Gere o token JWT com base na autenticação
            String token = tokenService.generateJwt(auth);

            // Agora, obtenha o usuário do repositório com base no nome de usuário
            Optional<Usuario> usuario = userRepository.findByEmail(email);

            if (usuario.isPresent()) {
                // Retorne o usuário e o token no DTO
                return new LoginResponseDTO(usuario.get(), token); // Use usuario.get() para obter o objeto Usuario
            } else {
                // Caso o usuário não seja encontrado, retorne null ou uma mensagem de erro
                return new LoginResponseDTO(null, "Usuário não encontrado");
            }
        } catch (AuthenticationException e) {
            // Em caso de falha na autenticação, retorne null ou uma mensagem de erro
            return new LoginResponseDTO(null, "Autenticação falhou");
        }



    }











}
