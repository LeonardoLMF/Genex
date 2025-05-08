package com.geraleo.genex.controller;

import com.geraleo.genex.domain.Questao;
import com.geraleo.genex.dto.CadastroQuestaoDTO;
import com.geraleo.genex.dto.QuestaoRespostaDTO;
import com.geraleo.genex.repository.QuestaoRepository;
import com.geraleo.genex.service.QuestaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    //Endpoint GET para listar todas as questoes
    @GetMapping
    public ResponseEntity<List<QuestaoRespostaDTO>> listarTodas(){
        return ResponseEntity.ok(questaoService.listarTodas());
    }
}
