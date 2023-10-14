package br.com.jaia.b1naryinspec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import br.com.jaia.b1naryinspec.dto.ClienteDTO;
import br.com.jaia.b1naryinspec.model.Cliente;
import br.com.jaia.b1naryinspec.repository.ClienteRepository;
import br.com.jaia.b1naryinspec.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService cliente;

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping
    public ResponseEntity<List<Cliente>> todosClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(cliente.buscarTodosClientes());
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<Object> bucarCnpjCliente(@PathVariable("cnpj") String clienteCnpj){
        Optional<Cliente> clienteOp = clienteRepo.findByClienteCnpj(clienteCnpj);
        if(!clienteOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente.buscarPorCnpj(clienteCnpj));
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Object> bucarNomeCliente(@PathVariable("nome") String clienteNome){
        Optional<Cliente> clienteOp = clienteRepo.findByClienteNome(clienteNome);
        if(!clienteOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente.buscarPorNome(clienteNome));
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Object> bucarIdCliente(@PathVariable("id") Long clienteId){
        Optional<Cliente> clienteOp = clienteRepo.findById(clienteId);
        if(!clienteOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente.buscarClienteId(clienteId));
    }

    @PostMapping
    public ResponseEntity<Cliente> novoCliente(@RequestBody ClienteDTO clienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente.novoCliente(clienteDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> editarCliente(@PathVariable("id") Long clienteId, @RequestBody ClienteDTO clienteDto){
        Optional<Cliente> clienteOp = clienteRepo.findById(clienteId);
        if(!clienteOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente.updateCliente(clienteId, clienteDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removerCliente(@PathVariable("id") Long clienteId){
        Optional<Cliente> clienteOp = clienteRepo.findById(clienteId);
        if(!clienteOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        cliente.deleteCliente(clienteId);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado!");
    }

}
