package br.com.jaia.b1naryinspec.repository;

import java.util.List;
import java.util.Optional;

import br.com.jaia.b1naryinspec.dto.PrestadorDto;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jaia.b1naryinspec.model.PrestadorServico;
import org.springframework.stereotype.Repository;


@Repository
public interface PrestadorRepository extends JpaRepository <PrestadorServico, Long> {

    public Optional<PrestadorServico> findByCnpj(String cnpj); 


    public PrestadorServico findByPrestadorId(Long prestadorId);

    List<PrestadorServico> findAllById(Iterable<Long> ids);

    public PrestadorServico findByUsuarioUsuarioId(Long usuarioId);


}
