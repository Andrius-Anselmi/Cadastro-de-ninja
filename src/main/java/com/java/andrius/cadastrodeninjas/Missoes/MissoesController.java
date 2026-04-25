package com.java.andrius.cadastrodeninjas.Missoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @Autowired
    MissoesService missoesService;

    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missoesService.criarMissao(missao);
    }

    @GetMapping("/listar")
    public List<MissoesDTO> mostrarTodasAsMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO mostrarPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarPorId(@PathVariable Long id, @RequestBody MissoesDTO missoes){
        return missoesService.alteraMissaoPorId(id, missoes);
        }

    @DeleteMapping("/deletar/{id}")
    public String deletarPorId(@PathVariable Long id){
        boolean missaoDeletada = missoesService.deletarMissaoPorId(id);
        if(missaoDeletada){
            return  "Missão deletada com sucesso";
        }else{
            return "Não foi possível deletar essa missão";
        }
    }
}

