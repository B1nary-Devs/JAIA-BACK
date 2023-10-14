package br.com.jaia.b1naryinspec.service;

import java.util.List;
import java.util.Optional;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.jaia.b1naryinspec.model.PrestadorServico;
import br.com.jaia.b1naryinspec.repository.PrestadorRepository;

@Service
public class PrestadorService {

    @Autowired
    private PrestadorRepository prestadorRepo;





    public PrestadorServico create(PrestadorServico prestadorServico) {
        return prestadorRepo.save(prestadorServico);
    }


    public List<PrestadorServico> findAll() {
        return prestadorRepo.findAll();
    }


    public PrestadorServico findById(Long id) {
        Optional<PrestadorServico> prestadorServicoOptional = prestadorRepo.findById(id);
        return prestadorServicoOptional.orElse(null);
    }


    public PrestadorServico update(Long id, PrestadorServico prestadorServico) {
        prestadorServico.setPrestadorId(id);
        return prestadorRepo.save(prestadorServico);
    }


    public void delete(Long id) {
        prestadorRepo.deleteById(id);
    }






}
