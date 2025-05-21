package com.geraleo.genex.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "provas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String topico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelDificuldade dificuldade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoQuestao tipo;

    @Column(nullable = false)
    private int quantidade;

    @Column(name = "data_criacao",nullable = false)
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "prova", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestaoDaProva> questoes;

}
