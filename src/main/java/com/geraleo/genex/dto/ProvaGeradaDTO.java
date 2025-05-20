package com.geraleo.genex.dto;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.TipoQuestao;

import java.util.List;

public class ProvaGeradaDTO {

    private String enunciado;
    private String topico;
    private NivelDificuldade dificuldade;
    private TipoQuestao tipo;
    private List<String> alternativas;

    public ProvaGeradaDTO(String enunciado, String topico, NivelDificuldade dificuldade,
                          TipoQuestao tipo, List<String> alternativas) {
        this.enunciado = enunciado;
        this.topico = topico;
        this.dificuldade = dificuldade;
        this.tipo = tipo;
        this.alternativas = alternativas;
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
}
