package br.com.jaia.b1naryinspec.service;

import java.util.List;

import br.com.jaia.b1naryinspec.entity.PrestadorServico;

public interface PrestadorInterface {
    
    public PrestadorServico novoPrestador(PrestadorServico prestador);

    public List<PrestadorServico> buscarTodosPrestadores();

    public PrestadorServico buscarPrestadoPorCnpj(String cnpj);

    public PrestadorServico buscarPrestadorPorEmail( String  email);
}
