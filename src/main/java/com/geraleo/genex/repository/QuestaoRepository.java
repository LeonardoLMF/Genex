package com.geraleo.genex.repository;

import com.geraleo.genex.domain.NivelDificuldade;
import com.geraleo.genex.domain.Questao;
import com.geraleo.genex.domain.TipoQuestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {

List<Questao> findByTopicoAndDificuldade(String topico, NivelDificuldade dificuldade);
List<Questao> findByTopicoAndDificuldadeAndTipo(String topico, NivelDificuldade dificuldade, TipoQuestao tipo);

}
