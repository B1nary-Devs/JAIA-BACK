package br.com.jaia.b1naryinspec.controller;



import br.com.jaia.b1naryinspec.model.Segmento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jaia.b1naryinspec.service.SegmentoService;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping("/segmento")
public class SegmentoController {



    @Autowired
    private SegmentoService segmentoService;

    @GetMapping
    public ResponseEntity<List<Segmento>> findAll() {
        List<Segmento> segmentos = segmentoService.findAll();
        return ResponseEntity.ok().body(segmentos);
    }

    @PostMapping
    public ResponseEntity<Segmento> novosegmento(@RequestBody Segmento segmento) {
        segmento = segmentoService.insert(segmento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(segmento.getId()).toUri();
        return ResponseEntity.created(uri).body(segmento);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Segmento> buscarporid(@PathVariable Long id) {
        Segmento segmento = segmentoService.findById(id);
        return ResponseEntity.ok().body(segmento);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        segmentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
