package br.com.jaia.b1naryinspec.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
public class OrdemServico {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ordem_servico_id")
    @Id
    private Long servicoId;

    @JsonFormat(pattern = "dd/MM/yyyy  HH:mm:ss")
    @Column(name =  "data_abertura" )
    private LocalDateTime dataAbertura;

    @JsonFormat(pattern = "dd/MM/yyyy  HH:mm:ss")
    @Column(name =  "data_fechamento" )
    private LocalDateTime dataFechamento;

    @Column(name =  "status" )
    private String status;


    @Column(name = "descricao")
    private String descricao;




    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinTable(name = "relacao_ordem_servico_prestador",
            joinColumns = @JoinColumn(name = "ordem_servico_id"),
            inverseJoinColumns = @JoinColumn(name = "prestador_id"))
    @JsonManagedReference
    Set<PrestadorServico> prestador = new HashSet<>();



    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "relacao_ordem_servico_checklist",
            joinColumns = @JoinColumn(name = "ordem_servico_id"),
            inverseJoinColumns = @JoinColumn(name = "checklist_id"))
    @JsonManagedReference
    Set<Checklist> checklists = new HashSet<>();


    public OrdemServico(Long servicoId, LocalDateTime dataAbertura, LocalDateTime dataFechamento, String status, String descricao, Cliente cliente, Set<PrestadorServico> prestador, Set<Checklist> checklists) {
        this.servicoId = servicoId;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.descricao = descricao;
        this.cliente = cliente;
        this.prestador = prestador;
        this.checklists = checklists;
    }

    public OrdemServico() {
    }


    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<PrestadorServico> getPrestador() {
        return prestador;
    }

    public void setPrestador(Set<PrestadorServico> prestador) {
        this.prestador = prestador;
    }

    public Set<Checklist> getChecklists() {
        return checklists;
    }

    public void setChecklists(Set<Checklist> checklists) {
        this.checklists = checklists;
    }







}
