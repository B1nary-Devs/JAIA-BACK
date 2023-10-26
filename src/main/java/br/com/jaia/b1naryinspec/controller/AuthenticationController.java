package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.security.AuthenticationRequest;
import br.com.jaia.b1naryinspec.security.AuthenticationResponse;
import br.com.jaia.b1naryinspec.security.AuthenticationService;
import br.com.jaia.b1naryinspec.security.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class AuthenticationController {




    @Autowired
    private  AuthenticationService authenticationService;









    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }




}
