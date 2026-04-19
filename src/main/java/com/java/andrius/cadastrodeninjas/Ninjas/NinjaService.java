package com.java.andrius.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    // Listar ninja por ID
    public NinjaModel listarNinjaPorId(Long id){
      Optional<NinjaModel> ninjaBuscado = ninjaRepository.findById(id);
      return  ninjaBuscado.orElse(null);
    }

    // Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Deletar um ninja por ID
    public boolean deletarNinjaPorId(Long id){
        if(ninjaRepository.existsById(id)){
            ninjaRepository.deleteById(id);
            return  true;
        }else{
            return false;
        }
    }
    //Alterar um ninja por ID
    public NinjaModel alterarNinjaPorId(NinjaModel ninjaAtualizado, Long id){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            ninjaRepository.save(ninjaAtualizado);
        }
        return ninjaAtualizado;
    }








}
