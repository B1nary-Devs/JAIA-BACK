package br.com.jaia.b1naryinspec.service;

import java.util.List;
import java.util.Optional;

import br.com.jaia.b1naryinspec.dto.PrestadorDto;
import br.com.jaia.b1naryinspec.model.PrestadorServico;

public interface PrestadorInterface {
    
    public PrestadorServico novoPrestador(PrestadorDto prestadorDto);

    public List<PrestadorServico> buscarTodosPrestadores();

    public PrestadorServico buscarPrestadoPorCnpj(String cnpj);

//    public PrestadorServico buscarPrestadorPorEmail( String  email);

//    public PrestadorServico buscarPrestadorPorNome(String prestadorNome);

    public PrestadorServico updatePrestador(Long prestadorId, PrestadorDto prestadorDto);

    public Optional<PrestadorServico> deletePrestador(Long prestadorId);

    public PrestadorServico findByPrestadorId(Long prestadorId);
}
