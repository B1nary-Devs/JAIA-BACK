package br.com.jaia.b1naryinspec.controller;


import br.com.jaia.b1naryinspec.dto.OrdemServicoDTO;
import br.com.jaia.b1naryinspec.dto.SegmentoDTO;
import br.com.jaia.b1naryinspec.model.OrdemServico;
import br.com.jaia.b1naryinspec.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<List<OrdemServico>> listarTodasOrdens() {
        List<OrdemServico> ordens = ordemServicoService.listartodos();
        return ResponseEntity.ok(ordens);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> editarOrdem(@PathVariable("id") Long id, @RequestBody OrdemServicoDTO dto ){

        OrdemServico ordemOp = ordemServicoService.burcarPorId(id);
        if(ordemOp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordem não encontrado");
        }

        dto.setServicoId(id);

        return ResponseEntity.status(HttpStatus.OK).body(ordemServicoService.create(dto));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id){

        OrdemServico OrdemServicoOptional = ordemServicoService.burcarPorId(id);
        if (OrdemServicoOptional == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordem de Servico não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(OrdemServicoOptional);

    }

    @GetMapping(value = "/prestador/{id}")
    public ResponseEntity<List<OrdemServico>> buscarPorIdPrestador(@PathVariable Long id) {
        List<OrdemServico> OrdemServicolist = ordemServicoService.buscarPorIdPrestador(id);

        if (OrdemServicolist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(OrdemServicolist);
        }

        return ResponseEntity.status(HttpStatus.OK).body(OrdemServicolist);
    }



    @GetMapping(value = "/cliente/{id}")
    public ResponseEntity<List<OrdemServico>> buscarPorIdCliente(@PathVariable Long id) {
        List<OrdemServico> OrdemServicolist = ordemServicoService.buscarPorCliente(id);

        if (OrdemServicolist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(OrdemServicolist);
        }

        return ResponseEntity.status(HttpStatus.OK).body(OrdemServicolist);
    }





}
