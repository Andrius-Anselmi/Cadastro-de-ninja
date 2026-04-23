package com.java.andrius.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper){
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninja){
        NinjaModel ninjaModel = ninjaMapper.mapDTO(ninja);
        NinjaModel ninjaSalvo = ninjaRepository.save(ninjaModel);
        return ninjaMapper.mapModel(ninjaSalvo);

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
