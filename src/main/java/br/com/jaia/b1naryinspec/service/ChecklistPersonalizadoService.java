package br.com.jaia.b1naryinspec.service;

import br.com.jaia.b1naryinspec.dto.ChecklistDTO;
import br.com.jaia.b1naryinspec.dto.ChecklistPersonalizadoDTO;
import br.com.jaia.b1naryinspec.dto.SegmentoDTO;
import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.model.ChecklistPersonalizado;
import br.com.jaia.b1naryinspec.model.OrdemServico;
import br.com.jaia.b1naryinspec.repository.ChecklistPersonalizadoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChecklistPersonalizadoService {


    final private ChecklistPersonalizadoRepository checklistPersonalizadoRepository;


    public ChecklistPersonalizadoService(ChecklistPersonalizadoRepository checklistPersonalizadoRepository) {
        this.checklistPersonalizadoRepository = checklistPersonalizadoRepository;
    }




    @Transactional
    public ChecklistPersonalizado salvar(ChecklistPersonalizadoDTO dto) {

        ChecklistPersonalizado checklistPersonalizado =  new ChecklistPersonalizado();
        checklistPersonalizado.setChecklistPersonalizadoId(dto.getChecklistPersonalizadoId());
        checklistPersonalizado.setChecklistPersonalizadoNome(dto.getChecklistPersonalizadoNome());
        checklistPersonalizado.setDescricao(dto.getDescricao());

        OrdemServico ordem = new OrdemServico();

        ordem.setServicoId(dto.getOrdemServicoId());

        checklistPersonalizado.setOrdemServico(ordem);

       return checklistPersonalizadoRepository.save(checklistPersonalizado);

    }


    public List<ChecklistPersonalizado> findAll(){
        return checklistPersonalizadoRepository.findAll();
    }




}
