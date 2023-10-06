package br.com.jaia.b1naryinspec.service;


import br.com.jaia.b1naryinspec.dto.OrdemServicoDTO;
import br.com.jaia.b1naryinspec.model.OrdemServico;
import br.com.jaia.b1naryinspec.repository.OrdemServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdemServicoService {


    @Autowired
    private OrdemServicoRepository ordemServicoRepository;




    @Transactional
    public OrdemServicoDTO create(OrdemServicoDTO dto) {
        OrdemServico entity = new OrdemServico();
        entity.setDataAbertura(dto.getDataAbertura());
        entity.setDataFechamento(dto.getDataFechamento());
        entity.setStatus(dto.getStatus());
        entity.setDescricao(dto.getDescricao());
        entity = ordemServicoRepository.save(entity);
        return new OrdemServicoDTO(entity);

    }


        @Transactional
        public List<OrdemServico> listartodos() {
            return ordemServicoRepository.findAll();
        }
































}
