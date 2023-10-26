package br.com.jaia.b1naryinspec.security;

import br.com.jaia.b1naryinspec.config.JwtService;
import br.com.jaia.b1naryinspec.model.UserRole;
import br.com.jaia.b1naryinspec.model.Usuario;
import br.com.jaia.b1naryinspec.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;



    @Autowired
    private  JwtService jwtService;



    @Autowired
    private  AuthenticationManager authenticationManager;




    public AuthenticationResponse register(RegisterRequest request) {
        var user = Usuario.UsuarioBuilder.builder()
                .withEmail(request.getEmail())
                .withSenha(passwordEncoder.encode(request.getSenha()))
                .withRole(UserRole.USER)
                .build();
        usuarioRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .withToken(jwtToken)
                .build();


    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getEmail()
                )
        );
        var user = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .withToken(jwtToken)
                .build();


    }


    public AuthenticationService() {
    }



}
