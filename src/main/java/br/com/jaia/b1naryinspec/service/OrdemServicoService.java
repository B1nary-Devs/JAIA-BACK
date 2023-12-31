package br.com.jaia.b1naryinspec.service;


import br.com.jaia.b1naryinspec.dto.OrdemServicoDTO;
import br.com.jaia.b1naryinspec.dto.PrestadorDto;
import br.com.jaia.b1naryinspec.dto.SolicitacaoDTO;
import br.com.jaia.b1naryinspec.exceptions.DataIntegrityViolationExceptionCustom;
import br.com.jaia.b1naryinspec.exceptions.ObjectNotFoundException;
import br.com.jaia.b1naryinspec.model.*;
import br.com.jaia.b1naryinspec.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class OrdemServicoService {


    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SegmentoRepository segmentoRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;


    @Autowired
    private SolicitacaoRepository solicitacaoRepository;



    @Transactional
    public OrdemServicoDTO create(OrdemServicoDTO dto) {

        OrdemServico entity = new OrdemServico();
        entity.setServicoId(dto.getServicoId());
        entity.setDataAbertura(dto.getDataAbertura());
        entity.setDataFechamento(dto.getDataFechamento());
        entity.setStatus(dto.getStatus());
        entity.setDescricao(dto.getDescricao());

        // Busque o Cliente com base no ID
        Optional<Cliente> optionalCliente = clienteRepository.findById(dto.getCliente());
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            entity.setCliente(cliente); // Associe o cliente à ordem de serviço
        } else {
            throw new ObjectNotFoundException("Cliente não encontrado com o ID: " + dto.getCliente());
        }

        if (dto.getPrestadores() != null && !dto.getPrestadores().isEmpty()) {
            List<PrestadorServico> prestadores = prestadorRepository.findAllById(dto.getPrestadores());
            entity.getPrestador().addAll(prestadores); // Adiciona os prestadores à lista da entidade
        } else {
            throw new DataIntegrityViolationExceptionCustom("A lista de prestadores está vazia ou nula.");
        }




        OrdemServico savedEntity = ordemServicoRepository.save(entity);
        // Verifique se a solicitação existe. Se não, salve a ordem de serviço sem uma solicitação
        if (dto.getSolicitacao() != null) {
            Optional<Solicitacao> optionalSolicitacao = solicitacaoRepository.findById(dto.getSolicitacao());
            if (optionalSolicitacao.isPresent()) {
                Solicitacao solicitacao = optionalSolicitacao.get();
                entity.setSolicitacao(solicitacao);
            } else {
                throw new ObjectNotFoundException("Solicitação não encontrada com o ID: " + dto.getSolicitacao());
            }
        }



        OrdemServicoDTO savedDTO = new OrdemServicoDTO();
        savedDTO.setServicoId(savedEntity.getServicoId());
        savedDTO.setDataAbertura(savedEntity.getDataAbertura());
        savedDTO.setDataFechamento(savedEntity.getDataFechamento());
        savedDTO.setStatus(savedEntity.getStatus());
        savedDTO.setDescricao(savedEntity.getDescricao());
        savedDTO.setCliente(savedEntity.getCliente().getClienteId());

        return savedDTO;

    }


    @Transactional
        public List<OrdemServico> listartodos() {
            return ordemServicoRepository.findAll();
        }


    public OrdemServico burcarPorId(Long id){
        return ordemServicoRepository.findOrdemServicoByServicoId(id);
    }


    public List<OrdemServico> buscarPorIdPrestador(Long id){
        return ordemServicoRepository.findByPrestadorPrestadorId(id);

    }


    public List<OrdemServico> buscarPorCliente(Long id){
        return ordemServicoRepository.findByClienteClienteId(id);
    }



}
