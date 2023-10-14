package br.com.jaia.b1naryinspec.repository;

import br.com.jaia.b1naryinspec.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository <OrdemServico, Long>{

    OrdemServico findOrdemServicoByServicoId(Long id);

}
