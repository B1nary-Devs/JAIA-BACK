package br.com.jaia.b1naryinspec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jaia.b1naryinspec.dto.PrestadorDto;
import br.com.jaia.b1naryinspec.entity.PrestadorServico;
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
        prestador.setPrestador_nome(prestadorDto.getPrestador_nome());
        prestador.setPrestador_id(prestadorDto.getPrestador_id());
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
    public PrestadorServico buscarPrestadorPorNome(String prestador_nome){
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findByPrestadorNome(prestador_nome);
        if(prestadorOp.isEmpty()){
             throw new IllegalArgumentException("Prestador de serviço não encontrado!");
        }
        return prestadorOp.get();
    }

    @Override
    public PrestadorServico updatePrestador(Long prestador_id, PrestadorDto prestadorDto){

        Optional<PrestadorServico> prestadorOp = prestadorRepo.findById(prestador_id);
        if(prestadorOp.isEmpty()){
             throw new IllegalArgumentException("Prestador de serviço não encontrado!");
        }
        PrestadorServico prestador = prestadorOp.get();
        prestador.setCnpj(prestadorDto.getCnpj());
        prestador.setEmail(prestadorDto.getEmail());
        prestador.setSenha(prestadorDto.getSenha());
        prestador.setPrestador_nome(prestadorDto.getPrestador_nome());
        prestador.setPrestador_id(prestadorDto.getPrestador_id());
        
        return prestadorRepo.save(prestador);
    }

    @Override
    public Optional<PrestadorServico> deletePrestador(Long prestador_id){
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findById(prestador_id);
        if(prestadorOp.isPresent()){
            prestadorRepo.deleteById(prestador_id);
        }
        return prestadorOp;
    }
    
}
