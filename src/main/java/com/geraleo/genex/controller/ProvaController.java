package com.geraleo.genex.controller;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.TipoQuestao;
import com.geraleo.genex.dto.GabaritoDTO;
import com.geraleo.genex.dto.GerarProvaDTO;
import com.geraleo.genex.dto.ProvaGeradaDTO;
import com.geraleo.genex.service.ProvaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provas")
@RequiredArgsConstructor
public class ProvaController {

    private final ProvaService provaService;

    @PostMapping
    public ResponseEntity<List<ProvaGeradaDTO>> gerarProva(@RequestBody @Valid GerarProvaDTO dto) {
        List<ProvaGeradaDTO> prova = provaService.gerarProva(dto);
        return ResponseEntity.ok(prova);
    }

    @GetMapping("/visualizar")
    public ResponseEntity<List<ProvaGeradaDTO>> visualizarProva(@RequestParam String topico,
                                                                @RequestParam NivelDificuldade dificuldade,
                                                                @RequestParam TipoQuestao tipo,
                                                                @RequestParam int quantidade) {

        GerarProvaDTO dto = new GerarProvaDTO();
        dto.setTopico(topico);
        dto.setDificuldade(dificuldade);
        dto.setTipo(tipo);
        dto.setQuantidade(quantidade);

        List<ProvaGeradaDTO> questoes = provaService.gerarProva(dto);
        return ResponseEntity.ok(questoes);
    }

    @GetMapping("/gabarito")
    public ResponseEntity<List<GabaritoDTO>> visualizarGabarito(@RequestParam String topico,
                                                                @RequestParam NivelDificuldade dificuldade,
                                                                @RequestParam TipoQuestao tipo,
                                                                @RequestParam int quantidade) {

        GerarProvaDTO dto = new GerarProvaDTO();
        dto.setTopico(topico);
        dto.setDificuldade(dificuldade);
        dto.setTipo(tipo);
        dto.setQuantidade(quantidade);

        List<GabaritoDTO> gabarito = provaService.gerarGabarito(dto);
        return ResponseEntity.ok(gabarito);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Long> gerarEGuardar(@RequestBody @Valid GerarProvaDTO dto) {
        Long id = provaService.gerarEGuardarProva(dto);
        return ResponseEntity.ok(id);
    }
}
