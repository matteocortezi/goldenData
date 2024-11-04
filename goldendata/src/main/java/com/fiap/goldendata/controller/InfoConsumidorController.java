package com.fiap.goldendata.controller;

import com.fiap.goldendata.model.InfoConsumidor;
import com.fiap.goldendata.repository.InfoConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("info-consumidor")
public class InfoConsumidorController {

    @Autowired
    private InfoConsumidorRepository infoConsumidorRepository;

    @GetMapping("/cadastrar")
    public String retornaInfoConsumidor() {
        return "infoConsumidor/cadastro";
    }

    @PostMapping("cadastrar")
    public String cadastrar(InfoConsumidor infoConsumidor, Model model){
        model.addAttribute("info", infoConsumidor);
        model.addAttribute("msg", "Verifique as preferências salvas abaixo!");
        return "infoConsumidor/sucesso";
    }

}
