package br.com.jaia.b1naryinspec.service;


import br.com.jaia.b1naryinspec.exceptions.ObjectNotFoundException;
import br.com.jaia.b1naryinspec.model.Segmento;
import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.repository.SegmentoRepository;
import br.com.jaia.b1naryinspec.repository.ChecklistRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;


    @Autowired
    private SegmentoRepository segmentoRepository;


    public Checklist create(Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    // Método para buscar todos os Checklists
    public List<Checklist> findAll() {
        return checklistRepository.findAll();
    }

    // Método para buscar um Checklist por ID
    public Checklist findById(Long id) {
        Optional<Checklist> checklistOptional = checklistRepository.findById(id);
        return checklistOptional.orElse(null);
    }

    // Método para atualizar um Checklist
    public Checklist update(Long id, Checklist checklist) {
        checklist.setChecklistId(id);
        return checklistRepository.save(checklist);
    }

    // Método para excluir um Checklist por ID
    public void delete(Long id) {
        checklistRepository.deleteById(id);
    }


}












