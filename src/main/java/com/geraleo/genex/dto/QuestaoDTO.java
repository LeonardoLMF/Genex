package com.geraleo.genex.dto;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.TipoQuestao;

public class QuestaoDTO {

    private Long id;    // Identificador da questão
    private String enunciado;   // Enunciado da questão
    private String respostaCorreta;     // Resposta correta da questão
    private String topico;  // Topico da questão
    private TipoQuestao tipo;   // Tipo da questão (objetiva, discursiva, etc..)
    private String[] alternativas;  // Lista de alternativas (A,B,C,D, etc...)
    private NivelDificuldade dificuldade;   // Dificuldade das questões

    //Construtor vazio
    public QuestaoDTO(){

    }

    // Construtor completo
    public QuestaoDTO(Long id, String enunciado, String respostaCorreta, String[] alternativas, String topico, TipoQuestao tipo, NivelDificuldade dificuldade ){

        this.id = id;
        this.enunciado = enunciado;
        this.respostaCorreta = respostaCorreta;
        this.alternativas = alternativas;
        this.topico = topico;
        this.tipo = tipo;
        this.dificuldade = dificuldade;
    }

    // getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    public TipoQuestao getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuestao tipo) {
        this.tipo = tipo;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String[] alternativas) {
        this.alternativas = alternativas;
    }

    public NivelDificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(NivelDificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }
}
