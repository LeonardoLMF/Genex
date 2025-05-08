package com.geraleo.genex.service;

import com.geraleo.genex.domain.Questao;
import com.geraleo.genex.dto.CadastroQuestaoDTO;
import com.geraleo.genex.repository.QuestaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    //metodo para listar todas as questoes
    public List<Questao> listarTodas(){
        return questaoRepository.findAll();
    }
}
