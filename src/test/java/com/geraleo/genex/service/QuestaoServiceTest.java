package com.geraleo.genex.service;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.Questao;
import com.geraleo.genex.domain.TipoQuestao;
import com.geraleo.genex.dto.CadastroQuestaoDTO;
import com.geraleo.genex.dto.QuestaoRespostaDTO;
import com.geraleo.genex.repository.QuestaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class QuestaoServiceTest {

    @InjectMocks
    private QuestaoService questaoService;

    @Mock
    private QuestaoRepository questaoRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void CadastrarQuestaoComSucesso() {
        CadastroQuestaoDTO dto = new CadastroQuestaoDTO();
        dto.setEnunciado("O que é Java?");
        dto.setResposta("Uma linguagem de programação.");
        dto.setTopico("Programação");
        dto.setDificuldade(NivelDificuldade.MEDIO);
        dto.setTipo(TipoQuestao.DISCURSIVA);
        dto.setAlternativas(List.of());

        Questao questaoMock = Questao.builder()
                .id(1L)
                .enunciado(dto.getEnunciado())
                .respostaCorreta(dto.getResposta())
                .topico(dto.getTopico())
                .dificuldade(dto.getDificuldade())
                .tipo(dto.getTipo())
                .alternativas(dto.getAlternativas())
                .build();

        when(questaoRepository.save(any())).thenReturn(questaoMock);

        Questao resultado = questaoService.cadastrar(dto);

        assertNotNull(resultado);
        assertEquals("O que é Java?", resultado.getEnunciado());
        assertEquals("Uma linguagem de programação.", resultado.getRespostaCorreta());
        verify(questaoRepository, times(1)).save(any());
    }

    @Test
    void BuscarQuestaoPorIdComSucesso() {
        Questao questao = Questao.builder()
                .id(1L)
                .enunciado("Enunciado")
                .topico("Topico")
                .dificuldade(NivelDificuldade.FACIL)
                .tipo(TipoQuestao.MULTIPLA_ESCOLHA)
                .alternativas(List.of("A", "B", "C"))
                .respostaCorreta("A")
                .build();

        when(questaoRepository.findById(1L)).thenReturn(Optional.of(questao));

        QuestaoRespostaDTO resultado = questaoService.buscarPorId(1L);

        assertEquals("Enunciado", resultado.getEnunciado());
        assertEquals("A", resultado.getRespostaCorreta());
        verify(questaoRepository, times(1)).findById(1L);
    }
}
