package br.com.jaia.b1naryinspec.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
public class OrdemServico {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ordem_servico")
    @Id
    private Long servicoId;

    @Column(name =  "data_abertura" )
    private LocalDateTime dataAbertura;

    @Column(name =  "data_fechamento" )
    private LocalDateTime dataFechamento;

    @Column(name =  "status" )
    private String status;


    @Column(name =  "cliente_id", unique = true )
    @OneToMany(mappedBy = "cliente_id", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Cliente> cliente;










}
