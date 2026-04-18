package com.java.andrius.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

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
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return  "Mostrando todos os ninjas";
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("todosID")
    public String mostrarPorId(int path){
        return  "Mostrando ninja por id";
    }


    //Altera dados dos Ninja (UPDATE)
    @PutMapping("alterarID")
    public String alterarPorId(){
        return  "Alterando ninja por ID";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("deletarID")
    public String deletarPorId(){
        return  "Deletando ninja pro ID";
    }
}
