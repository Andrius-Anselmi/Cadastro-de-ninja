package com.java.andrius.cadastrodeninjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //Adiconar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return  "Ninja criado com sucesso";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return  ninjaService.listarNinjas();
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("listar/{id}")
    public NinjaModel mostrarPorId(@PathVariable Long id){
        return  ninjaService.listarNinjaPorId(id);
    }

    //Altera dados dos Ninja (UPDATE)
    @PutMapping("/alterarID")
    public String alterarPorId(){
        return  "Alterando ninja por ID";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarPorId(){
        return  "Deletando ninja pro ID";
    }
}
