package br.com.jaia.b1naryinspec.model;

import jakarta.persistence.*;

@Entity
@Table(name = "checklist")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_id")
    private Long checklist_id;

    @Column(name = "checklist_nome")
    private String checklist_nome;

    public Checklist(Long checklist_id, String checklist_nome) {
        this.checklist_id = checklist_id;
        this.checklist_nome = checklist_nome;
    }

    public Checklist(){
    }

    public Long getChecklist_id() {
        return checklist_id;
    }

    public void setChecklist_id(Long checklist_id) {
        this.checklist_id = checklist_id;
    }

    public String getChecklist_nome() {
        return checklist_nome;
    }

    public void setChecklist_nome(String checklist_nome) {
        this.checklist_nome = checklist_nome;
    }
}
