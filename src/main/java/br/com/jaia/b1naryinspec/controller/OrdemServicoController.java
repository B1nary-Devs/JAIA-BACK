package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.dto.OrdemServicoDTO;
import br.com.jaia.b1naryinspec.dto.SegmentoDTO;
import br.com.jaia.b1naryinspec.model.OrdemServico;
import br.com.jaia.b1naryinspec.model.Segmento;
import br.com.jaia.b1naryinspec.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordemservico")
public class OrdemServicoController {




    @Autowired
    OrdemServicoService ordemServicoService;





    @PostMapping
    public ResponseEntity<OrdemServicoDTO> insert(@RequestBody OrdemServicoDTO dto){
        dto = ordemServicoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getServicoId()).toUri();


        return ResponseEntity.created(uri).body(dto);


    }


    @GetMapping
    public ResponseEntity<List<OrdemServicoDTO>> findAll(){
        List<OrdemServico> list = ordemServicoService.listartodos();
        List<OrdemServicoDTO> listDto = list.stream().map(obj -> new OrdemServicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);


    }






}
