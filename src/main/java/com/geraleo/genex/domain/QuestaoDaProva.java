package com.geraleo.genex.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "questoes_da_prova")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestaoDaProva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prova_id", nullable = false)
    private Prova prova;

    @Column(nullable = false, length = 750)
    private String enunciado;

    @ElementCollection
    @CollectionTable(name = "alternativas_questao_prova", joinColumns = @JoinColumn(name = "questao_id"))
    @Column(name = "alternativa", nullable = false)
    private List<String> alternativas;

    @Column(name = "resposta_correta", nullable = false)
    private String respostaCorreta;
}