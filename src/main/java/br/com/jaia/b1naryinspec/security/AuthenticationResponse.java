package br.com.jaia.b1naryinspec.security;

public class AuthenticationResponse {


    private String token;


    public AuthenticationResponse(String token) {
        this.token = token;
    }


    public AuthenticationResponse() {
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }




    public static class AuthenticationResponseBuilder {
        private String token;

        public AuthenticationResponseBuilder withToken(String token) {
            this.token = token;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(token);
        }
    }

    public static AuthenticationResponseBuilder builder() {
        return new AuthenticationResponseBuilder();
    }




}
