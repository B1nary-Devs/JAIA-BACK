package br.com.jaia.b1naryinspec.security;

import br.com.jaia.b1naryinspec.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {



    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("In the user details service");

        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("usuario nao localizado"));
    }


}
