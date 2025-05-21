package com.geraleo.genex.dto;

public class GabaritoDTO {
    private String enunciado;
    private String respostaCorreta;

    public GabaritoDTO(String enunciado, String respostaCorreta) {
        this.enunciado = enunciado;
        this.respostaCorreta = respostaCorreta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }
}
