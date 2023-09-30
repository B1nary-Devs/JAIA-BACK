package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.dto.SegmentoDTO;
import br.com.jaia.b1naryinspec.model.Segmento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jaia.b1naryinspec.service.SegmentoService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RequestMapping("/segmento")
public class SegmentoController {



    @Autowired
    private SegmentoService segmentoService;



    @GetMapping
    public ResponseEntity<List<SegmentoDTO>> findAll(){
        List<Segmento> list = segmentoService.findAll();
        List<SegmentoDTO> listDto = list.stream().map(obj -> new SegmentoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);


    }





    @PostMapping
    public ResponseEntity<SegmentoDTO> insert(@RequestBody SegmentoDTO dto){
        dto = segmentoService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getId()).toUri();


        return ResponseEntity.created(uri).body(dto);


    }







    @GetMapping(value = "/{id}")
    public ResponseEntity<SegmentoDTO> findById(@PathVariable Long id){
        SegmentoDTO dto  = segmentoService.FindById(id);
        return ResponseEntity.ok().body(dto);


    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        segmentoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
