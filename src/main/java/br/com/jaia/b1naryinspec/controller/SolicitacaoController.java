package br.com.jaia.b1naryinspec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jaia.b1naryinspec.dto.SolicitacaoDTO;
import br.com.jaia.b1naryinspec.model.Solicitacao;
import br.com.jaia.b1naryinspec.repository.SolicitacaoRepository;
import br.com.jaia.b1naryinspec.service.SolicitacaoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/solicitacao")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private SolicitacaoService solicitacaoService;;

    @GetMapping
    public ResponseEntity<List<Solicitacao>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(solicitacaoService.buscarTodasSolicitacoes());
    }

    @GetMapping(value = "/{solicitacaoId}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("solicitacaoId") Long solicitacaoId){
        Optional<Solicitacao> solicitacaoOp = Optional.ofNullable(solicitacaoRepository.findBySolicitacaoId(solicitacaoId));
        if(!solicitacaoOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Solicitação não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(solicitacaoService.buscarSolicitacaoId(solicitacaoId));
    }

    @PostMapping
    public ResponseEntity<Solicitacao> novaSolicitacao(@RequestBody SolicitacaoDTO solicitacaoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoService.novaSolicitacao((solicitacaoDTO)));
    }

    @PutMapping(value = "/{solicitacaoId}")
    public ResponseEntity<Object> editarSolicitacao(@PathVariable("solicitacaoId") Long solicitacaoId, @RequestBody SolicitacaoDTO solicitacaoDTO){
        Optional<Solicitacao> solicitacaoOp = solicitacaoRepository.findById(solicitacaoId);
        if(!solicitacaoOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Solicitação não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(solicitacaoService.updateSolicitacao(solicitacaoId, solicitacaoDTO));
    }

    @DeleteMapping(value = "/{solicitacaoId}")
    public ResponseEntity<String> removerSolicitacao(@PathVariable("solicitacaoId") Long solicitacaoId){
        Optional<Solicitacao> solicitacaoOp = solicitacaoRepository.findById(solicitacaoId);
        if(!solicitacaoOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Solicitação não encontrada.");
        }
        solicitacaoService.deleteSolicitacao(solicitacaoId);
        return ResponseEntity.status(HttpStatus.OK).body("Solicitação deletada.");
    }

}
