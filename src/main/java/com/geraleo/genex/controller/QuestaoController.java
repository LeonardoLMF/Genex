package com.geraleo.genex.controller;

import com.geraleo.genex.domain.Questao;
import com.geraleo.genex.dto.CadastroQuestaoDTO;
import com.geraleo.genex.service.QuestaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questoes")
@RequiredArgsConstructor
public class QuestaoController {

    private final QuestaoService questaoService;

    @PostMapping
    public ResponseEntity<Questao> cadastrar(@RequestBody CadastroQuestaoDTO dto){
        Questao novaQuestao = questaoService.cadastrar(dto);
        return ResponseEntity.ok(novaQuestao);
    }
}
