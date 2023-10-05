package br.com.jaia.b1naryinspec.exceptions;

public class DataIntegrityViolationExceptionCustom extends RuntimeException{
    public DataIntegrityViolationExceptionCustom(String message) {
        super(message);
    }
}
