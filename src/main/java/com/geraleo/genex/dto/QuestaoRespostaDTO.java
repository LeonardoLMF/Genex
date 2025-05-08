package com.geraleo.genex.dto;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.TipoQuestao;

import java.util.List;

public class QuestaoRespostaDTO {
    private Long id;
    private String enunciado;
    private String topico;
    private NivelDificuldade dificuldade;
    private TipoQuestao tipo;
    private List<String> alternativas;
    private String respostaCorreta;

    public QuestaoRespostaDTO(Long id, String enunciado, String topico, NivelDificuldade dificuldade,
                              TipoQuestao tipo, List<String> alternativas, String respostaCorreta) {
        this.id = id;
        this.enunciado = enunciado;
        this.topico = topico;
        this.dificuldade = dificuldade;
        this.tipo = tipo;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    public Long getId() {
        return id;
    }
    public String getEnunciado() {
        return enunciado;
    }
    public String getTopico() {
        return topico;
    }
    public NivelDificuldade getDificuldade() {
        return dificuldade;
    }
    public TipoQuestao getTipo() {
        return tipo;
    }
    public List<String> getAlternativas() {
        return alternativas;
    }
    public String getRespostaCorreta() {
        return respostaCorreta;
    }
}
