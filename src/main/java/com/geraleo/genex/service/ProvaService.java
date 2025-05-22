package com.geraleo.genex.service;

import com.geraleo.genex.domain.Prova;
import com.geraleo.genex.domain.Questao;
import com.geraleo.genex.domain.QuestaoDaProva;
import com.geraleo.genex.dto.GabaritoDTO;
import com.geraleo.genex.dto.GerarProvaDTO;
import com.geraleo.genex.dto.ProvaGeradaDTO;
import com.geraleo.genex.repository.ProvaRepository;
import com.geraleo.genex.repository.QuestaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvaService {

    private final QuestaoRepository questaoRepository;
    private final ProvaRepository provaRepository;



    public List<ProvaGeradaDTO> gerarProva(GerarProvaDTO dto) {
        List<Questao> questoesFiltradas = questaoRepository.findByTopicoAndDificuldadeAndTipo(
                dto.getTopico(), dto.getDificuldade(), dto.getTipo()
        );

        Collections.shuffle(questoesFiltradas); // embaralha
        List<Questao> selecionadas = questoesFiltradas.stream()
                .limit(dto.getQuantidade())
                .toList();

        return selecionadas.stream()
                .map(q -> new ProvaGeradaDTO(
                        q.getEnunciado(),
                        q.getTopico(),
                        q.getDificuldade(),
                        q.getTipo(),
                        q.getAlternativas()
                )).toList();
    }

    public List<GabaritoDTO> gerarGabarito(GerarProvaDTO dto) {
        List<Questao> questoes = questaoRepository.findByTopicoAndDificuldadeAndTipo(
                dto.getTopico(), dto.getDificuldade(), dto.getTipo()
        );

        Collections.shuffle(questoes);

        return questoes.stream()
                .limit(dto.getQuantidade())
                .map(q -> new GabaritoDTO(q.getEnunciado(), q.getRespostaCorreta()))
                .toList();
    }

    public Long gerarEGuardarProva(GerarProvaDTO dto) {
        List<Questao> questoesFiltradas = questaoRepository.findByTopicoAndDificuldadeAndTipo(
                dto.getTopico(), dto.getDificuldade(), dto.getTipo()
        );

        Collections.shuffle(questoesFiltradas);
        List<Questao> selecionadas = questoesFiltradas.stream()
                .limit(dto.getQuantidade())
                .toList();

        Prova novaProva = Prova.builder()
                .topico(dto.getTopico())
                .dificuldade(dto.getDificuldade())
                .tipo(dto.getTipo())
                .quantidade(selecionadas.size())
                .dataCriacao(LocalDateTime.now())
                .build();

        List<QuestaoDaProva> questoesDaProva = selecionadas.stream()
                .map(q -> QuestaoDaProva.builder()
                        .prova(novaProva)
                        .enunciado(q.getEnunciado())
                        .alternativas(List.copyOf(q.getAlternativas()))
                        .respostaCorreta(q.getRespostaCorreta())
                        .build())
                .collect(Collectors.toList());

        novaProva.setQuestoes(questoesDaProva);
        Prova salva = provaRepository.save(novaProva);
        return salva.getId();
    }

    public Prova buscarProvaPorId(Long id) {
        return provaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prova não encontrada com ID: " + id));
    }

    public List<Prova> listarTodasAsProvas() {
        return provaRepository.findAll();
    }


}
