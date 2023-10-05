package br.com.jaia.b1naryinspec.service;


import br.com.jaia.b1naryinspec.dto.SegmentoDTO;
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
    public SegmentoDTO FindById(Long id) {
        Optional<Segmento> obj = segmentoRepository.findById(id);
        Segmento entity = obj.orElseThrow();
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
            // Trate exceções de violação de integridade, se necessário
            throw new RuntimeException("Erro ao inserir a categoria: " + e.getMessage());
        } catch (Exception e) {
            // Trate outras exceções aqui
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
            throw new RuntimeException("id nao localizada");
        }
    }

    public void delete(Long id) {
        FindById(id);
        try{
            segmentoRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Categoria nao pode ser deletada, pois possui livros associados a esta");

        }

    }



}
