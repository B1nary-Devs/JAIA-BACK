package br.com.jaia.b1naryinspec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jaia.b1naryinspec.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Optional<Cliente> findById(Long clienteId);

    public Optional<Cliente> findByClienteCnpj(String clienteCnpj);

    public Optional<Cliente> findByClienteNome(String clienteNome);

}
