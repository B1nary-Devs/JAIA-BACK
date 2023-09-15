package br.com.jaia.b1naryinspec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jaia.b1naryinspec.entity.PrestadorServico;
import br.com.jaia.b1naryinspec.repository.PrestadorRepository;

@Service
public class PrestadorService implements PrestadorInterface {

    @Autowired
    private PrestadorRepository prestadorRepo;

    @Override
    public PrestadorServico novoPrestador(PrestadorServico prestador) {
        if(prestador == null || 
            prestador.getEmail() == null ||
            prestador.getEmail().isBlank() ||
            prestador.getSenha() == null ||
            prestador.getSenha().isBlank()){
                throw new IllegalArgumentException("Dados Invalidos");
        }
        return prestadorRepo.save(prestador);
    }

    @Override
    public List<PrestadorServico> buscarTodosPrestadores() {
        return prestadorRepo.findAll();
    }

    @Override
    public PrestadorServico buscarPrestadoPorCnpj(String cnpj) {
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findByCnpj(cnpj);
        if(prestadorOp.isEmpty()){
            throw new IllegalArgumentException("Prestador de serviço não encontrado!");
        }

        return prestadorOp.get();
    }

    @Override
    public PrestadorServico buscarPrestadorPorEmail(String email) {
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findByEmail(email);
        if(prestadorOp.isEmpty()){
            throw new IllegalArgumentException("Prestador de serviço não encontrado!");
        }
        return prestadorOp.get();
    }
    
}
