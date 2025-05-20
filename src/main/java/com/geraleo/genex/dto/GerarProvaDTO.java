package com.geraleo.genex.dto;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.TipoQuestao;
import jakarta.validation.constraints.*;

public class GerarProvaDTO {

    @NotBlank(message = "O tópico é obrigatório.")
    private String topico;

    @NotNull(message = "A dificuldade é obrigatória.")
    private NivelDificuldade dificuldade;

    @NotNull(message = "O tipo da questão é obrigatório.")
    private TipoQuestao tipo;

    @Min(value = 1, message = "A quantidade mínima de questões é 1.")
    @Max(value = 50, message = "A quantidade máxima de questões é 50.")
    private int quantidade;


    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    public NivelDificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(NivelDificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public TipoQuestao getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuestao tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

