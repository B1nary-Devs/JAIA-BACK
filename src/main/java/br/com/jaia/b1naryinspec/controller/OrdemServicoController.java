package br.com.jaia.b1naryinspec.controller;



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
    public ResponseEntity<OrdemServico> insert(@RequestBody OrdemServico dto) {
        OrdemServico createdDTO = ordemServicoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdDTO.getServicoId()).toUri();

        return ResponseEntity.created(uri).body(createdDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrdemServico>> listarTodasOrdens() {
        List<OrdemServico> ordens = ordemServicoService.findAll();
        return ResponseEntity.ok(ordens);
    }



    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> findById(@PathVariable Long id) {
        OrdemServico ordemServico = ordemServicoService.findById(id);
        return ResponseEntity.ok(ordemServico);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ordemServicoService.delete(id);
        return ResponseEntity.noContent().build();
    }










}
