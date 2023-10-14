package br.com.jaia.b1naryinspec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jaia.b1naryinspec.model.Cliente;
import br.com.jaia.b1naryinspec.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepo;

    @Transactional
    public Cliente novoCliente(Cliente clienteDto){
        if(clienteDto == null ){
            throw new IllegalArgumentException("Dados Invalidos!");
        }

        Cliente cliente = new Cliente();
        cliente.setClienteCnpj(clienteDto.getClienteCnpj());
        cliente.setClienteNome(clienteDto.getClienteNome());

        return clienteRepo.save(cliente);
    }

    @Transactional
    public List<Cliente> buscarTodosClientes(){
        return clienteRepo.findAll();
    }

    @Transactional
    public Cliente buscarClienteId(Long clienteId){
        Optional<Cliente> clienteOp = clienteRepo.findById(clienteId);
        if(clienteOp.isEmpty()){
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
        return clienteOp.get();
    }

    @Transactional
    public Cliente buscarPorCnpj(String clienteCnpj){
        Optional<Cliente> clienteOp = clienteRepo.findByClienteCnpj(clienteCnpj);
        if(clienteOp.isEmpty()){
            throw new IllegalArgumentException("Cliente não encontrado!");
        }

        return clienteOp.get();
    }

    @Transactional
    public Cliente buscarPorNome(String clienteNome){
        Optional<Cliente> clienteOp = clienteRepo.findByClienteNome(clienteNome);
        if(clienteOp.isEmpty()){
            throw new IllegalArgumentException("Cliente não encontrado!");
        }

        return clienteOp.get();
    }

    @Transactional
    public Cliente updateCliente(Long clienteId, Cliente clienteDto){

        Optional<Cliente> clienteOp = clienteRepo.findById(clienteId);
        if(clienteOp.isEmpty()){
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
        Cliente cliente = clienteOp.get();
        cliente.setClienteCnpj(clienteDto.getClienteCnpj()); 
        cliente.setClienteNome(clienteDto.getClienteNome());

        return clienteRepo.save(cliente);
    }

    @Transactional
    public Optional<Cliente> deleteCliente(Long clienteId){
        Optional<Cliente> clienteOp = clienteRepo.findById(clienteId);
        if(clienteOp.isEmpty()){
            throw new IllegalArgumentException("Cliente não encontrado!");
        }else{
            clienteRepo.deleteById(clienteId);
        }

        return clienteOp;
    }

}
