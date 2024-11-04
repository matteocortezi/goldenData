package com.fiap.goldendata.controller;

import com.fiap.goldendata.model.CadastroConsumidor;
import com.fiap.goldendata.repository.CadastroConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("cadastro-consumidor")
public class CadastroConsumidorController {

    @Autowired
    private CadastroConsumidorRepository cadastroConsumidorRepository;

    @GetMapping("/cadastrar")
    public String retornaCadastro() {
        return "cadastroConsumidor/cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(CadastroConsumidor cadastroConsumidor, RedirectAttributes redirectAttributes) {
        cadastroConsumidorRepository.save(cadastroConsumidor);
        redirectAttributes.addFlashAttribute("msg", "Cadastrado com sucesso!");
        return "redirect:/cadastro-consumidor/listar";
    }

    @GetMapping("/listar")
    public String listarConsumidores(Model model) {
        List<CadastroConsumidor> consumidores = cadastroConsumidorRepository.findAll();
        model.addAttribute("consumidores", consumidores);
        return "cadastroConsumidor/lista";
    }

    @GetMapping("/editar/{id}")
    public String retornaEdicao(@PathVariable Long id, Model model) {
        CadastroConsumidor consumidor = cadastroConsumidorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
        model.addAttribute("consumidor", consumidor);
        return "cadastroConsumidor/edicao";
    }

    @PostMapping("/atualizar")
    public String atualizar(CadastroConsumidor cadastroConsumidor, RedirectAttributes redirectAttributes) {
        cadastroConsumidorRepository.save(cadastroConsumidor);
        redirectAttributes.addFlashAttribute("msg", "Atualizado com sucesso!");
        return "redirect:/cadastro-consumidor/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        cadastroConsumidorRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "Deletado com sucesso!");
        return "redirect:/cadastro-consumidor/listar";
    }
}
