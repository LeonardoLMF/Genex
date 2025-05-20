package com.geraleo.genex.service;

import com.geraleo.genex.domain.Questao;
import com.geraleo.genex.dto.GerarProvaDTO;
import com.geraleo.genex.dto.ProvaGeradaDTO;
import com.geraleo.genex.repository.QuestaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvaService {

    private final QuestaoRepository questaoRepository;

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


}
