package br.com.jaia.b1naryinspec.service;


import br.com.jaia.b1naryinspec.dto.SegmentoDTO;
import br.com.jaia.b1naryinspec.exceptions.DataIntegrityViolationExceptionCustom;
import br.com.jaia.b1naryinspec.exceptions.ObjectNotFoundException;
import br.com.jaia.b1naryinspec.model.Segmento;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.com.jaia.b1naryinspec.repository.SegmentoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SegmentoService {


    @Autowired
    private SegmentoRepository segmentoRepository;



    @Transactional
    public SegmentoDTO findById(Long id) {
        Optional<Segmento> obj = segmentoRepository.findById(id);
        Segmento entity = obj.orElseThrow(() -> new ObjectNotFoundException("Segmento não encontrado com o id: " + id));
        return new SegmentoDTO(entity);


    }



    @Transactional
    public List<Segmento> findAll(){
        return segmentoRepository.findAll();

    }


    @Transactional(rollbackFor = Exception.class) // Defina exceções específicas, se aplicável
    public SegmentoDTO insert(SegmentoDTO dto) {
        try {
            Segmento entity = new Segmento();
            entity.setNome(dto.getNome());
            entity = segmentoRepository.save(entity);
            return new SegmentoDTO(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationExceptionCustom("Erro ao inserir a categoria: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir a categoria: " + e.getMessage());
        }
    }


    @Transactional
    public SegmentoDTO update(Long id , SegmentoDTO dto) {
        try {
            Segmento entity = segmentoRepository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity = segmentoRepository.save(entity);
            return new SegmentoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ObjectNotFoundException("id nao localizado");
        }
    }

    public void delete(Long id) {
        findById(id);
        try{
            segmentoRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationExceptionCustom("Segmento nao pode ser deletado, pois possui Prestadores associados a esta");

        }

    }



}
