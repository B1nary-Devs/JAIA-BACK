package br.com.jaia.b1naryinspec.repository;


import br.com.jaia.b1naryinspec.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {

}
