package com.geraleo.genex.service;

import com.geraleo.genex.domain.Questao;
import com.geraleo.genex.dto.CadastroQuestaoDTO;
import com.geraleo.genex.dto.QuestaoRespostaDTO;
import com.geraleo.genex.repository.QuestaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestaoService {

    private final QuestaoRepository questaoRepository;

    public Questao cadastrar(CadastroQuestaoDTO dto){
        Questao questao = Questao.builder()
                .enunciado(dto.getEnunciado())
                .respostaCorreta(dto.getResposta())
                .topico(dto.getTopico())
                .dificuldade(dto.getDificuldade())
                .tipo(dto.getTipo())
                .alternativas(dto.getAlternativas())
                .build();

        return questaoRepository.save(questao);
    }

    private QuestaoRespostaDTO converterParaDTO(Questao questao) {
        return new QuestaoRespostaDTO(
                questao.getId(),
                questao.getEnunciado(),
                questao.getTopico(),
                questao.getDificuldade(),
                questao.getTipo(),
                questao.getAlternativas(),
                questao.getRespostaCorreta()
        );
    }

    //metodo para listar todas as questoes
    public List<QuestaoRespostaDTO> listarTodas(){
        return questaoRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public QuestaoRespostaDTO buscarPorId(Long id){
        Questao questao = questaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Questão não encontrada"));

        return converterParaDTO(questao);
    }
}
