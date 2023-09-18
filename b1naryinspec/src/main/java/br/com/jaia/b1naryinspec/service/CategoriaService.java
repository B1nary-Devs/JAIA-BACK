package br.com.jaia.b1naryinspec.service;


import br.com.jaia.b1naryinspec.model.Categoria;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public Categoria buscarid(Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new EmptyResultDataAccessException(1));


    }



    @Transactional
    public List<Categoria> buscartodos(){
        return categoriaRepository.findAll();


    }


    @Transactional
    public Categoria criar(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);

    }


    @Transactional
    public Categoria atualizar(Long id , Categoria obj) {
        Categoria CategoriaSalva = buscarid(id);

        BeanUtils.copyProperties(obj, CategoriaSalva, "id");
        return categoriaRepository.save(CategoriaSalva);
    }





    public void deletar(Long id) {
        buscarid(id);
        try{
            categoriaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Id nao localizado");

        }


    }






}
