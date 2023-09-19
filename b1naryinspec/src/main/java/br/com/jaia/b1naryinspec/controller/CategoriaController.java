package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.model.Categoria;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.jaia.b1naryinspec.repository.CategoriaRepository;
import br.com.jaia.b1naryinspec.service.CategoriaService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/categoria")
public class CategoriaController {


    @Autowired
    private CategoriaService categoriaService;


    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping
    public List<Categoria> listartodos() {
        return categoriaRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj, HttpServletResponse response){
        obj = categoriaService.criar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Categoria> buscarPeloId(@PathVariable Long codigo) {
        Optional<Categoria> categoria = categoriaRepository.findById(codigo);

        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
