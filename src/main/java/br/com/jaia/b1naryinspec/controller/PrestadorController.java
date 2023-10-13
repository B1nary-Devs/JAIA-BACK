
package br.com.jaia.b1naryinspec.controller;

import java.util.List;
import java.util.Optional;

import br.com.jaia.b1naryinspec.service.PrestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jaia.b1naryinspec.model.PrestadorServico;
import br.com.jaia.b1naryinspec.repository.PrestadorRepository;

@RestController
@RequestMapping(value = "/prestador")
public class PrestadorController{



    @Autowired
    private PrestadorService prestadorService;

    @PostMapping
    public ResponseEntity<PrestadorServico> createPrestador(@RequestBody PrestadorServico prestador) {
        PrestadorServico createdPrestador = prestadorService.create(prestador);
        return ResponseEntity.ok(createdPrestador);
    }

    // Endpoint para buscar todos os Prestadores de Serviço
    @GetMapping
    public ResponseEntity<List<PrestadorServico>> findAllPrestadores() {
        List<PrestadorServico> prestadores = prestadorService.findAll();
        return ResponseEntity.ok(prestadores);
    }

    // Endpoint para buscar um Prestador de Serviço por ID
    @GetMapping("/{id}")
    public ResponseEntity<PrestadorServico> findPrestadorById(@PathVariable Long id) {
        PrestadorServico prestador = prestadorService.findById(id);
        if (prestador != null) {
            return ResponseEntity.ok(prestador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para atualizar um Prestador de Serviço por ID
    @PutMapping("/{id}")
    public ResponseEntity<PrestadorServico> updatePrestador(@PathVariable Long id, @RequestBody PrestadorServico prestador) {
        PrestadorServico updatedPrestador = prestadorService.update(id, prestador);
        return ResponseEntity.ok(updatedPrestador);
    }

    // Endpoint para excluir um Prestador de Serviço por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestador(@PathVariable Long id) {
        prestadorService.delete(id);
        return ResponseEntity.noContent().build();
    }


}