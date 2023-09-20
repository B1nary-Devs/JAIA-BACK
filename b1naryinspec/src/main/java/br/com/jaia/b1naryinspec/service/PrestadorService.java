package br.com.jaia.b1naryinspec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jaia.b1naryinspec.dto.PrestadorDto;
import br.com.jaia.b1naryinspec.model.PrestadorServico;
import br.com.jaia.b1naryinspec.repository.PrestadorRepository;

@Service
public class PrestadorService implements PrestadorInterface {

    @Autowired
    private PrestadorRepository prestadorRepo;

    @Override
    public PrestadorServico novoPrestador(PrestadorDto prestadorDto) {
        if(prestadorDto == null || 
            prestadorDto.getEmail() == null ||
            prestadorDto.getEmail().isBlank() ||
            prestadorDto.getSenha() == null ||
            prestadorDto.getSenha().isBlank()){
                throw new IllegalArgumentException("Dados Invalidos");
        }
        PrestadorServico prestador = new PrestadorServico();
        prestador.setCnpj(prestadorDto.getCnpj());
        prestador.setEmail(prestadorDto.getEmail());
        prestador.setSenha(prestadorDto.getSenha());
        prestador.setPrestadorNome(prestadorDto.getPrestadorNome());
        prestador.setPrestadorId(prestadorDto.getPrestadorId());
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

    @Override
    public PrestadorServico buscarPrestadorPorNome(String prestadorNome){
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findByPrestadorNome(prestadorNome);
        if(prestadorOp.isEmpty()){
             throw new IllegalArgumentException("Prestador de serviço não encontrado!");
        }
        return prestadorOp.get();
    }

    @Override
    public PrestadorServico updatePrestador(Long prestadorId, PrestadorDto prestadorDto){

        Optional<PrestadorServico> prestadorOp = prestadorRepo.findById(prestadorId);
        if(prestadorOp.isEmpty()){
             throw new IllegalArgumentException("Prestador de serviço não encontrado!");
        }
        PrestadorServico prestador = prestadorOp.get();
        prestador.setCnpj(prestadorDto.getCnpj());
        prestador.setEmail(prestadorDto.getEmail());
        prestador.setSenha(prestadorDto.getSenha());
        prestador.setPrestadorNome(prestadorDto.getPrestadorNome());        
        
        return prestadorRepo.save(prestador);
    }

    @Override
    public Optional<PrestadorServico> deletePrestador(Long prestadorId){
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findById(prestadorId);
        if(prestadorOp.isPresent()){
            prestadorRepo.deleteById(prestadorId);
        }
        return prestadorOp;
    }
    
}
