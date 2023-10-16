package br.com.jaia.b1naryinspec.repository;

import br.com.jaia.b1naryinspec.model.Segmento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SegmentoRepository extends JpaRepository<Segmento,Long> {


}
