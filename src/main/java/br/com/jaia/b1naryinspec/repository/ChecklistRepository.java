package br.com.jaia.b1naryinspec.repository;


import br.com.jaia.b1naryinspec.model.Checklist;
import br.com.jaia.b1naryinspec.model.PrestadorServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {


    Checklist findByChecklistId(Long id);

    Checklist findByChecklistNome(String nome);
}
