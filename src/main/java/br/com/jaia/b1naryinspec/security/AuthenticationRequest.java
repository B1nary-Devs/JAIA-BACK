package br.com.jaia.b1naryinspec.security;

public class AuthenticationRequest {



    private String email;

    private String senha;


    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
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

    public static class AuthenticationRequestBuilder {
        private String email;
        private String senha;

        public AuthenticationRequestBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AuthenticationRequestBuilder withSenha(String senha) {
            this.senha = senha;
            return this;
        }

        public AuthenticationRequest build() {
            return new AuthenticationRequest(email, senha);
        }
    }

    public static AuthenticationRequestBuilder builder() {
        return new AuthenticationRequestBuilder();
    }





}
