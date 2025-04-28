package com.geraleo.genex.dto;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.TipoQuestao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroQuestaoDTO {
    @NotBlank(message = "Campo obrigatório.")
    private String enunciado;

    @NotBlank(message = "A respostá da questão é obrigatória.")
    private String resposta;

    @NotBlank(message = "O tópico da questão é obrigatorio.")
    private String topico;

    @NotNull(message = "O nivel da questão é obrigatorio.")
    private NivelDificuldade dificuldade;

    @NotNull(message = "O tipo da questão é obrigatorio.")
    private TipoQuestao tipo;
}
