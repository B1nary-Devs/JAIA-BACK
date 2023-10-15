package br.com.jaia.b1naryinspec.service;

import java.util.List;
import java.util.Optional;

import br.com.jaia.b1naryinspec.exceptions.DataIntegrityViolationExceptionCustom;
import br.com.jaia.b1naryinspec.exceptions.ObjectNotFoundException;
import br.com.jaia.b1naryinspec.model.Segmento;
import br.com.jaia.b1naryinspec.repository.SegmentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jaia.b1naryinspec.dto.PrestadorDto;
import br.com.jaia.b1naryinspec.model.PrestadorServico;
import br.com.jaia.b1naryinspec.repository.PrestadorRepository;

@Service
public class PrestadorService implements PrestadorInterface {

    @Autowired
    private PrestadorRepository prestadorRepo;

    @Autowired
    private SegmentoRepository segmentoRepository;

    @Transactional
    public PrestadorServico novoPrestador(PrestadorDto prestadorDto) {
        if (prestadorDto == null ||
                prestadorDto.getEmail() == null ||
                prestadorDto.getEmail().isBlank() ||
                prestadorDto.getSenha() == null ||
                prestadorDto.getSenha().isBlank() ||
                prestadorDto.getSegmentoId() == null) {
            throw new DataIntegrityViolationExceptionCustom("Dados Inválidos");
        }

        PrestadorServico prestador = new PrestadorServico();
        prestador.setCnpj(prestadorDto.getCnpj());
        prestador.setEmail(prestadorDto.getEmail());
        prestador.setSenha(prestadorDto.getSenha());
        prestador.setPrestadorNome(prestadorDto.getPrestadorNome());

        // Busque a categoria com base no segmentoId
        Segmento segmento = segmentoRepository.findById(prestadorDto.getSegmentoId())
                .orElseThrow(() -> new ObjectNotFoundException("Segmento não encontrado"));

        // Defina a categoria no prestador
        prestador.setSegmento(segmento);

        return prestadorRepo.save(prestador);
    }

    @Transactional
    public List<PrestadorServico> buscarTodosPrestadores() {


        return prestadorRepo.findAll();
    }






    @Transactional
    public PrestadorServico buscarPrestadoPorCnpj(String cnpj) {
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findByCnpj(cnpj);
        if(prestadorOp.isEmpty()){
            throw new ObjectNotFoundException("Prestador de serviço não encontrado!");
        }

        return prestadorOp.get();
    }

    @Transactional
    public PrestadorServico findByPrestadorId(Long prestadorId) {
        Optional<PrestadorServico> prestadorOp = Optional.ofNullable(prestadorRepo.findByPrestadorId(prestadorId));
        if(prestadorOp.isEmpty()){
            throw new ObjectNotFoundException("Prestador de serviço não encontrado!");
        }
        return prestadorOp.get();
    }


    public PrestadorServico buscarPrestadorPorEmail(String email) {
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findByEmail(email);
        if(prestadorOp.isEmpty()){
            throw new ObjectNotFoundException("Prestador de serviço não encontrado!");
        }
        return prestadorOp.get();
    }



    @Transactional
    public PrestadorServico buscarPrestadorPorNome(String prestadorNome){
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findByPrestadorNome(prestadorNome);
        if(prestadorOp.isEmpty()){
             throw new ObjectNotFoundException("Prestador de serviço não encontrado!");
        }
        return prestadorOp.get();
    }

    @Transactional
    public PrestadorServico updatePrestador(Long prestadorId, PrestadorDto prestadorDto){

        Optional<PrestadorServico> prestadorOp = prestadorRepo.findById(prestadorId);
        if(prestadorOp.isEmpty()){
             throw new ObjectNotFoundException("Prestador de serviço não encontrado!");
        }
        PrestadorServico prestador = prestadorOp.get();
        prestador.setCnpj(prestadorDto.getCnpj());
        prestador.setEmail(prestadorDto.getEmail());
        prestador.setSenha(prestadorDto.getSenha());
        prestador.setPrestadorNome(prestadorDto.getPrestadorNome());

        Segmento segmento = new Segmento();
        segmento.setId(prestadorDto.getSegmentoId());
        prestador.setSegmento(segmento);

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
