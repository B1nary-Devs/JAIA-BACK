
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

import br.com.jaia.b1naryinspec.dto.PrestadorDto;
import br.com.jaia.b1naryinspec.model.PrestadorServico;
import br.com.jaia.b1naryinspec.repository.PrestadorRepository;
import br.com.jaia.b1naryinspec.service.PrestadorInterface;

@RestController
@RequestMapping(value = "/prestador")
@CrossOrigin
public class PrestadorController{

    @Autowired
    private PrestadorInterface prestador;

    @Autowired
    private PrestadorRepository prestadorRepo;

    @GetMapping
    public ResponseEntity<List<PrestadorServico>> todosPrestadores(){
        return ResponseEntity.status(HttpStatus.OK).body(prestador.buscarTodosPrestadores());
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<Object> buscarPorCnpj(@PathVariable("cnpj") String cnpj){

        Optional<PrestadorServico> prestadorOp = prestadorRepo.findByCnpj(cnpj);
        if(!prestadorOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestador não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(prestador.buscarPrestadoPorCnpj(cnpj));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<Object> buscarPorEmail(@PathVariable("email") String email){

        Optional<PrestadorServico> prestadorOp = prestadorRepo.findByEmail(email);
        if(!prestadorOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestador não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(prestador.buscarPrestadorPorEmail(email));
    }

    @GetMapping(value = "/nome/{prestadorNome}")
    public ResponseEntity<Object> buscarPrestadorPorNome(@PathVariable("prestadorNome") String prestadorNome){

        Optional<PrestadorServico> prestadorOp = prestadorRepo.findByPrestadorNome(prestadorNome);
        if(!prestadorOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestador não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(prestador.buscarPrestadorPorNome(prestadorNome));
    }

    @PostMapping
    public ResponseEntity<PrestadorServico> novoPrestador(@RequestBody PrestadorDto prestadorServ){
        return ResponseEntity.status(HttpStatus.CREATED).body(prestador.novoPrestador(prestadorServ));
    }

    @PutMapping(value = "/{prestadorId}")
    public ResponseEntity<Object> editarPrestador(@PathVariable("prestadorId") Long prestadorId, @RequestBody PrestadorDto prestadorDto ){
        
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findById(prestadorId);
        if(!prestadorOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestador não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(prestador.updatePrestador(prestadorId, prestadorDto));
    }

    @DeleteMapping(value = "/{prestadorId}")
    public ResponseEntity<String> removerPrestador(@PathVariable("prestadorId") Long prestadorId){
        
        Optional<PrestadorServico> prestadorOp = prestadorRepo.findById(prestadorId);

        if(!prestadorOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestador não encontrado");
        }
        prestador.deletePrestador(prestadorId);
        return ResponseEntity.status(HttpStatus.OK).body("Prestador deletado!");
    }



}