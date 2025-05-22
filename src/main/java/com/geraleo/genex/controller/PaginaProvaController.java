package com.geraleo.genex.controller;

import com.geraleo.genex.domain.Prova;
import com.geraleo.genex.service.ProvaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaginaProvaController {

    private final ProvaService provaService;

    // Página principal: painel com todas as provas
    @GetMapping("/provas")
    public String listarProvas(Model model) {
        List<Prova> provas = provaService.listarTodasAsProvas();
        model.addAttribute("provas", provas);
        return "painel";
    }

    // Página visual da prova com base no ID
    @GetMapping("/provas/{id}")
    public String visualizarProva(@PathVariable Long id, Model model) {
        Prova prova = provaService.buscarProvaPorId(id);
        model.addAttribute("prova", prova);
        model.addAttribute("questoes", prova.getQuestoes());
        return "prova";
    }

    // Página visual do gabarito da prova com base no ID
    @GetMapping("/provas/{id}/gabarito")
    public String visualizarGabarito(@PathVariable Long id, Model model) {
        Prova prova = provaService.buscarProvaPorId(id);
        model.addAttribute("prova", prova);
        model.addAttribute("questoes", prova.getQuestoes());
        return "gabarito";
    }
}
