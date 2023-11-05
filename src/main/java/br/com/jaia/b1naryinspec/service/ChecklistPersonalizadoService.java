package br.com.jaia.b1naryinspec.service;

import br.com.jaia.b1naryinspec.dto.ChecklistPersonalizadoDTO;
import br.com.jaia.b1naryinspec.model.ChecklistPersonalizado;
import br.com.jaia.b1naryinspec.model.OrdemServico;
import br.com.jaia.b1naryinspec.model.Segmento;
import br.com.jaia.b1naryinspec.repository.ChecklistPersonalizadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

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
        checklistPersonalizado.setObservacao(dto.getObservacao());
        checklistPersonalizado.setSituacao(dto.getSituacao());

        Segmento segmento = new Segmento();

        segmento.setId(dto.getSegmentoId());
        
        checklistPersonalizado.setSegmento(segmento);

        OrdemServico ordem = new OrdemServico();

        ordem.setServicoId(dto.getOrdemServicoId());

        checklistPersonalizado.setOrdemServico(ordem);

       return checklistPersonalizadoRepository.save(checklistPersonalizado);

    }


    public List<ChecklistPersonalizado> findAll(){
        return checklistPersonalizadoRepository.findAll();
    }


    public  ChecklistPersonalizado findByChecklistPersonalizadoId(Long id){
        return checklistPersonalizadoRepository.findByChecklistPersonalizadoId(id);
    }


}
