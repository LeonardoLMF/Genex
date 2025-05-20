package com.geraleo.genex.controller;

import com.geraleo.genex.dto.GerarProvaDTO;
import com.geraleo.genex.dto.ProvaGeradaDTO;
import com.geraleo.genex.service.ProvaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/provas")
@RequiredArgsConstructor
public class ProvaController {

    private final ProvaService provaService;

    @PostMapping
    public ResponseEntity<List<ProvaGeradaDTO>> gerarProva(@RequestBody @Valid GerarProvaDTO dto){
        List<ProvaGeradaDTO> prova = provaService.gerarProva(dto);
        return ResponseEntity.ok(prova);
    }


}
