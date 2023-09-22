package br.com.jaia.b1naryinspec.service;


import br.com.jaia.b1naryinspec.dto.CategoriaDTO;
import br.com.jaia.b1naryinspec.model.Categoria;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.com.jaia.b1naryinspec.repository.CategoriaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;



    @Transactional
    public CategoriaDTO FindById(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        Categoria entity = obj.orElseThrow();
        return new CategoriaDTO(entity);


    }



    @Transactional
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();


    }


    @Transactional
    public CategoriaDTO insert(CategoriaDTO dto) {
        Categoria entity = new Categoria();
        entity.setNome(dto.getNome());
        entity = categoriaRepository.save(entity);
        return new CategoriaDTO(entity);

    }


    @Transactional
    public CategoriaDTO update(Long id , CategoriaDTO dto) {
        try {
            Categoria entity = categoriaRepository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity = categoriaRepository.save(entity);
            return new CategoriaDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("id nao localizada");
        }
    }

    public void delete(Long id) {
        FindById(id);
        try{
            categoriaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Categoria nao pode ser deletada, pois possui livros associados a esta");

        }

    }



}
