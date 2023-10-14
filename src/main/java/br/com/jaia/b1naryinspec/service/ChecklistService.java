package br.com.jaia.b1naryinspec.service;

import br.com.jaia.b1naryinspec.dto.ChecklistDTO;
import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.repository.ChecklistRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    private final ChecklistRepository checklistRepository;


    public ChecklistService(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }


    @Transactional
    public Checklist salvar(ChecklistDTO dto) {
        if(dto == null ||
                dto.getChecklistNome() == null ||
                dto.getChecklistNome().isBlank()) {
            throw new IllegalArgumentException("Check com atributos inválidos!");
        }
        Checklist checklist = new Checklist();
        checklist.setChecklistNome(dto.getChecklistNome());
        checklist.setSegmentos(dto.getSegmentos());

        return checklistRepository.save(checklist);
    }

    public List<Checklist> buscarTudo(){
        return checklistRepository.findAll();
    }

    public Checklist findByChecklistId(Long id){
        return checklistRepository.findByChecklistId(id);
    }


    public Checklist findByChecklistNome(String nome){
        return checklistRepository.findByChecklistNome(nome);
    }

    @Transactional
    public void delete (Checklist checklist){
        checklistRepository.delete(checklist);
    }



}












