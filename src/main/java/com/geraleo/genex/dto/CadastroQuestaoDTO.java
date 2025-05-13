package com.geraleo.genex.dto;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.TipoQuestao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CadastroQuestaoDTO {

    @NotBlank(message = "O enunciado da questão é obrigatório.")
    @Size(max = 600, message = "O Enunciado deve ter no máximo 600 caracteres.")
    private String enunciado;

    @NotBlank(message = "A respostá da questão é obrigatória.")
    private String resposta;

    @NotBlank(message = "O tópico da questão é obrigatório.")
    @Size(max = 200, message = "O tópico da questão deve ter no máximo 200 caracteres.")
    private String topico;


    @NotNull(message = "O nivel de dificuldade é obrigatório.")
    private NivelDificuldade dificuldade;

    @NotNull(message = "O tipo da questão é obrigatório.")
    private TipoQuestao tipo;

    @Size(min = 2, max = 5, message = "A questão deve conter entre 2 e 5 alternativas")
    private List<@NotBlank(message = "Alternativas não podem estar vazias.") String> alternativas;
}
