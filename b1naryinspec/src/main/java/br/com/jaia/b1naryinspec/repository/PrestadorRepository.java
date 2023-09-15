package br.com.jaia.b1naryinspec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jaia.b1naryinspec.entity.PrestadorServico;

public interface PrestadorRepository extends JpaRepository <PrestadorServico, Long> {
    
    public Optional<PrestadorServico> findByEmail(String email); 

    public Optional<PrestadorServico> findByCnpj(String cnpj); 
}
