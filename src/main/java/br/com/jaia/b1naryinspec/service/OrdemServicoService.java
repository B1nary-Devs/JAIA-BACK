package br.com.jaia.b1naryinspec.service;



import br.com.jaia.b1naryinspec.exceptions.ObjectNotFoundException;
import br.com.jaia.b1naryinspec.model.OrdemServico;
import br.com.jaia.b1naryinspec.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class OrdemServicoService {



    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico create(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    public void delete(Long id) {
        OrdemServico ordemServico = findById(id);
        ordemServicoRepository.delete(ordemServico);
    }

    public OrdemServico findById(Long id) {
        return ordemServicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Ordem de serviço não encontrada com o ID: " + id));
    }


    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }



}
