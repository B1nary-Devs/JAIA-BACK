package br.com.jaia.b1naryinspec.service;

import java.util.List;
import java.util.Optional;

import br.com.jaia.b1naryinspec.exceptions.ObjectNotFoundException;
import br.com.jaia.b1naryinspec.model.Segmento;
import br.com.jaia.b1naryinspec.repository.SegmentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jaia.b1naryinspec.dto.SolicitacaoDTO;
import br.com.jaia.b1naryinspec.model.Solicitacao;
import br.com.jaia.b1naryinspec.repository.SolicitacaoRepository;
import jakarta.transaction.Transactional;

@Service
public class SolicitacaoService {
    
    @Autowired
    private SolicitacaoRepository solicitacaoRepo;

    @Autowired
    private SegmentoRepository segmentoRepository;

    @Transactional
    public Solicitacao novaSolicitacao(SolicitacaoDTO solicitacaoDTO){
        if(solicitacaoDTO == null){
            throw new IllegalArgumentException("Solicitação inválida.");
        }

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setDescricao(solicitacaoDTO.getDescricao());
        solicitacao.setResultado(solicitacaoDTO.getResultado());
        solicitacao.setNomeEmpresa(solicitacaoDTO.getNomeEmpresa());
        solicitacao.setCnpj(solicitacaoDTO.getCnpj());

        // Busque a categoria com base no segmentoId
        Segmento segmento = segmentoRepository.findById(solicitacaoDTO.getSegmento())
                .orElseThrow(() -> new ObjectNotFoundException("Segmento não encontrado"));

        solicitacao.setSegmento(segmento);

        return solicitacaoRepo.save(solicitacao);
    }

    @Transactional
    public List<Solicitacao> buscarTodasSolicitacoes(){
        return solicitacaoRepo.findAll();
    }

    @Transactional
    public Solicitacao buscarSolicitacaoId(Long solicitacaoId){
        Optional<Solicitacao> solicitiacaoOp = solicitacaoRepo.findById(solicitacaoId);
        if (solicitiacaoOp.isEmpty()) {
            throw new IllegalArgumentException("Solicitação não encontrada!");
        }
        return solicitiacaoOp.get();
    }

    @Transactional
    public Solicitacao updateSolicitacao(Long solicitacaoId, SolicitacaoDTO solicitacaoDTO){
        Optional<Solicitacao> solicitacaoOp = solicitacaoRepo.findById(solicitacaoId);
        if (solicitacaoOp.isEmpty()){
            throw new IllegalArgumentException("Solicitação não encontrada!");
    }

    Solicitacao solicitacao = solicitacaoOp.get();
    solicitacao.setDescricao(solicitacaoDTO.getDescricao());
    solicitacao.setResultado(solicitacaoDTO.getResultado());
    solicitacao.setNomeEmpresa(solicitacao.getNomeEmpresa());
    solicitacao.setCnpj(solicitacaoDTO.getCnpj());

    return solicitacaoRepo.save(solicitacao);

    }

    public Optional<Solicitacao> deleteSolicitacao(Long solicitacaoId){
        Optional<Solicitacao> solicitacaoOp = solicitacaoRepo.findById(solicitacaoId);
        if(solicitacaoOp.isPresent()){
            solicitacaoRepo.deleteById(solicitacaoId);
        }
        return solicitacaoOp;
    }

}
