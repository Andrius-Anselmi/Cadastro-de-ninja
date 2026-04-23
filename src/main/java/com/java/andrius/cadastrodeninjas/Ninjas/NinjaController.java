package com.java.andrius.cadastrodeninjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return  ninjaService.criarNinja(ninja);
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
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarPorId(@RequestBody NinjaModel ninjaAtualizado, @PathVariable Long id){
        return ninjaService.alterarNinjaPorId(ninjaAtualizado,id);
    }
    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deletarPorId(@PathVariable Long id){
        boolean ninjaDeletado = ninjaService.deletarNinjaPorId(id);
        if(ninjaDeletado){
            return "Ninja deletado com sucesso";
        }else{
            return "Não foi possível deletar o ninja";
        }
    }


}