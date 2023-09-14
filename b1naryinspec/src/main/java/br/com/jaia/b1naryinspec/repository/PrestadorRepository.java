package br.com.jaia.b1naryinspec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jaia.b1naryinspec.entity.PrestadorServico;

public interface PrestadorRepository extends JpaRepository <PrestadorServico, Long> {
    
}
