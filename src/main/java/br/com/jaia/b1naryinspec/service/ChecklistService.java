package br.com.jaia.b1naryinspec.service;

import br.com.jaia.b1naryinspec.dto.SegmentoDTO;
import br.com.jaia.b1naryinspec.dto.ChecklistDTO;
import br.com.jaia.b1naryinspec.model.Segmento;
import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.repository.SegmentoRepository;
import br.com.jaia.b1naryinspec.repository.ChecklistRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;


    @Autowired
    private SegmentoRepository segmentoRepository;


    public ChecklistService(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }








    @Transactional
    public ChecklistDTO salvar(ChecklistDTO dto) {
        Checklist entity = new Checklist();
        copyDtoToEntity(dto, entity);
        entity = checklistRepository.save(entity);
        return new ChecklistDTO(entity);
    }


    public Checklist findById(Long id){
        Optional<Checklist> obj = checklistRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Objeto nao localizado"));
    }





    public List<ChecklistDTO> findAllChecklistsWithCategorias() {
        List<Checklist> checklists = checklistRepository.findAll();
        List<ChecklistDTO> checklistDTOs = new ArrayList<>();

        for (Checklist checklist : checklists) {
            ChecklistDTO checklistDTO = new ChecklistDTO();
            checklistDTO.setChecklistId(checklist.getChecklistId());
            checklistDTO.setChecklistNome(checklist.getChecklistNome());

            // Copie a lista de categorias convertendo de Categoria para CategoriaDTO
            checklistDTO.setSegmentos(checklist.getSegmentos().stream()
                    .map(segmento -> new SegmentoDTO(segmento))
                    .collect(Collectors.toList()));

            checklistDTOs.add(checklistDTO);
        }

        return checklistDTOs;
    }










    public void excluir(Long id) {
            Checklist checklist = checklistRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Checklist com ID " + id + " não encontrado"));

        checklist.getSegmentos().clear();
        checklistRepository.delete(checklist);
    }















    private void copyDtoToEntity(ChecklistDTO dto, Checklist entity) {
        entity.setChecklistNome(dto.getChecklistNome());

        for (SegmentoDTO catDto : dto.getSegmentos()) {
            try {
                Segmento category = segmentoRepository.getReferenceById(catDto.getId());
                entity.getSegmentos().add(category);
            }catch (EntityNotFoundException e) {
                // Lide com a exceção de entidade não encontrada de forma apropriada,
            }

        }



    }



}












