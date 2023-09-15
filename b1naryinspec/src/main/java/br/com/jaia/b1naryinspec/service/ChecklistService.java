package br.com.jaia.b1naryinspec.service;

import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.repository.ChecklistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    private final ChecklistRepository checklistRepository;


    public ChecklistService(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }


    @Transactional
    public List<Checklist> findAll(){
        return checklistRepository.findAll();
    }


}
