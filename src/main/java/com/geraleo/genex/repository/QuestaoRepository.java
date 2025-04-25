package com.geraleo.genex.repository;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {

List<Questao> findByTopicoAndDificuldade(String topico, NivelDificuldade dificuldade);

}
