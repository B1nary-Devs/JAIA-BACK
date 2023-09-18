package br.com.jaia.b1naryinspec.model;

import jakarta.persistence.*;

@Entity
@Table(name = "checklist")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_id")
    private Long checklistId;

    @Column(name = "checklist_nome", nullable = false)
    private String checklistNome;

    public Checklist(Long checklist_id, String checklist_nome) {
        this.checklistId = checklist_id;
        this.checklistNome = checklist_nome;
    }

    public Checklist(){
    }

    public Long getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Long checklistId) {
        this.checklistId = checklistId;
    }

    public String getChecklistNome() {
        return checklistNome;
    }

    public void setChecklistNome(String checklistNome) {
        this.checklistNome = checklistNome;
    }
}
