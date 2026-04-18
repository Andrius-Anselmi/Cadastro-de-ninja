package com.java.andrius.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @PostMapping("/criar")
    public String criarMissao(){
        return  "Missão criada";
    }

    @GetMapping("/listar")
    public String mostrarTodasAsMissoes(){
        return  "Mostrando missões";
    }

    @GetMapping("/listarID")
    public String mostrarPorId(){
        return "Mostrando missão por id";
    }

    @PutMapping("/alterarID")
    public String alterarPorId(){
        return "Missão alterado com sucesso";
        }

    @DeleteMapping("/deletarID")
    public String deletarPorId(){
        return "Missão deltado com sucesso";
    }
}

