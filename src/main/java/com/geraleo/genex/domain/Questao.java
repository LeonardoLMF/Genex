package com.geraleo.genex.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity // define que essa classe sera uma tabela no banco de dados
@Table(name = "questions") // nome da tabela no banco
@Setter // gera automaticamente os setters
@Getter // gera automaticamente os getters
@AllArgsConstructor // gera construtor com todos os argumentos
@NoArgsConstructor // gera construtor sem argumentos
@Builder // permite construir objetos com o padrão builder
public class Questao {

    @Id // Chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
    private Long id;

    @Column(nullable = false, length = 750)
    private String enunciado;

    @Column(nullable = false)
    private String topico;

    @Enumerated(EnumType.STRING)
    private NivelDificuldade nivel;

    @Enumerated(EnumType.STRING)
    private TipoQuestao tipo;

    @ElementCollection
    private List<String> alternativas;

    @Column(name = "resposta_correta", nullable = false)
    private String respostaCorreta;
}
