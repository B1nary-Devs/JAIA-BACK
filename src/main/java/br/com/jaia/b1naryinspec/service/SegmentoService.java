package br.com.jaia.b1naryinspec.service;


import br.com.jaia.b1naryinspec.exceptions.DataIntegrityViolationException;
import br.com.jaia.b1naryinspec.exceptions.ObjectNotFoundException;
import br.com.jaia.b1naryinspec.model.Segmento;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Segmento findById(Long id) {
        Optional<Segmento> optionalSegmento = segmentoRepository.findById(id);

        if (optionalSegmento.isPresent()) {
            return optionalSegmento.get();
        } else {
            throw new ObjectNotFoundException("Segmento não encontrado com o id: " + id);
        }
    }

    @Transactional
    public List<Segmento> findAll() {
        return segmentoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Segmento insert(Segmento segmento) {
        try {
            return segmentoRepository.save(segmento);
        } catch (Exception e) {
            throw new DataIntegrityViolationException("Erro ao inserir o segmento: " + e.getMessage());
        }
    }

    @Transactional
    public Segmento update(Long id, Segmento segmento) {
        try {
            findById(id); // Verifica se o segmento existe antes de atualizar
            segmento.setId(id); // Define o ID para garantir que a atualização seja para o segmento correto
            return segmentoRepository.save(segmento);
        } catch (EntityNotFoundException e) {
            throw new ObjectNotFoundException("Segmento não encontrado com o ID: " + id);
        }
    }

    public void delete(Long id) {
        findById(id); // Verifica se o segmento existe antes de tentar excluir
        try {
            segmentoRepository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Segmento não pode ser deletado, pois possui Prestadores associados a ele.");
        }
    }


}
