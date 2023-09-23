package br.com.jaia.b1naryinspec.repository;


import br.com.jaia.b1naryinspec.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {





}
