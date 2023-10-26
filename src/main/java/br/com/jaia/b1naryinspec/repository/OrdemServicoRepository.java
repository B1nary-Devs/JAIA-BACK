package br.com.jaia.b1naryinspec.repository;

import br.com.jaia.b1naryinspec.model.OrdemServico;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemServicoRepository extends JpaRepository <OrdemServico, Long>{

    OrdemServico findOrdemServicoByServicoId(Long id);

    List<OrdemServico> findByPrestadorPrestadorId(Long prestadorId);

    List<OrdemServico> findByClienteClienteId(Long clienteId);

//    OrdemServico findByClienteClienteIdAndStatus(Long clienteId, String status);

}
