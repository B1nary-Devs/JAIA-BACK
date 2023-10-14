package br.com.jaia.b1naryinspec.dto;

import br.com.jaia.b1naryinspec.model.Segmento;

import java.util.ArrayList;
import java.util.List;


public class SegmentoDTO {

    private Long id;
    private String nome;


    private List<ChecklistDTO> checklists= new ArrayList<>();

    public SegmentoDTO() {
    }


    public SegmentoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public SegmentoDTO(Segmento entity){
        this.id = entity.getId();
        this.nome = entity.getNome();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }









}
