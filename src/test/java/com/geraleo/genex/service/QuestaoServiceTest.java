package com.geraleo.genex.service;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.Questao;
import com.geraleo.genex.domain.TipoQuestao;
import com.geraleo.genex.dto.CadastroQuestaoDTO;
import com.geraleo.genex.dto.QuestaoRespostaDTO;
import com.geraleo.genex.repository.QuestaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

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
    void CadastrarUmaQuestaoComSucesso() {
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

    @Test
    void LancarExcecao_QuandoBuscarPorIdInexistente() {
        when(questaoRepository.findById(99L)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> questaoService.buscarPorId(99L)
        );

        assertEquals("404 NOT_FOUND \"Questão não encontrada\"", exception.getMessage());
        verify(questaoRepository, times(1)).findById(99L);
    }

    @Test
    void ListarTodasAsQuestoes() {
        Questao questao = Questao.builder()
                .id(1L)
                .enunciado("Enunciado de teste")
                .topico("Spring Boot")
                .dificuldade(NivelDificuldade.MEDIO)
                .tipo(TipoQuestao.DISCURSIVA)
                .respostaCorreta("Resposta")
                .alternativas(List.of())
                .build();

        when(questaoRepository.findAll()).thenReturn(List.of(questao));

        List<QuestaoRespostaDTO> lista = questaoService.listarTodas();

        assertEquals(1, lista.size());
        assertEquals("Enunciado de teste", lista.get(0).getEnunciado());
        verify(questaoRepository, times(1)).findAll();
    }

    @Test
    void DeletarQuestaoComSucesso() {
        Questao questao = Questao.builder().id(1L).build();

        when(questaoRepository.findById(1L)).thenReturn(Optional.of(questao));
        doNothing().when(questaoRepository).delete(questao);

        questaoService.deletar(1L);

        verify(questaoRepository, times(1)).findById(1L);
        verify(questaoRepository, times(1)).delete(questao);
    }

    @Test
    void LancarExcecaoQuandoDeletarIdInexistente() {
        when(questaoRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> questaoService.deletar(99L));
        verify(questaoRepository, times(1)).findById(99L);
    }
}
