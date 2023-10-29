package br.com.jaia.b1naryinspec.security;

public class RegistrationDTO {

    private String email;
    private String senha;


    public RegistrationDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;



    }


    public RegistrationDTO() {
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


    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }









}
