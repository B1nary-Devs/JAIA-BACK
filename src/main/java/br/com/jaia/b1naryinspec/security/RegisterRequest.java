package br.com.jaia.b1naryinspec.security;

public class RegisterRequest {


    private String email;
    private String senha;



    public RegisterRequest() {
    }

    public RegisterRequest(String email, String senha) {
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

    public static class RegisterRequestBuilder {
        private String email;
        private String senha;

        public RegisterRequestBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public RegisterRequestBuilder withSenha(String senha) {
            this.senha = senha;
            return this;
        }

        public RegisterRequest build() {
            return new RegisterRequest(email, senha);
        }
    }

    public static RegisterRequestBuilder builder() {
        return new RegisterRequestBuilder();
    }



}
