package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.model.Usuario;
import br.com.jaia.b1naryinspec.security.AuthenticationService;
import br.com.jaia.b1naryinspec.security.LoginResponseDTO;
import br.com.jaia.b1naryinspec.security.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;



    @PostMapping("/register")
    public Usuario registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getEmail(), body.getSenha());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getEmail(), body.getSenha());
    }




}
