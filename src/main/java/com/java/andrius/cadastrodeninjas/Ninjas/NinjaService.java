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
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjaModels = ninjaRepository.findAll();
        return ninjaModels.stream()
                .map((ninjaModel) -> ninjaMapper.mapModel(ninjaModel))
                .toList();
    }

    // Listar ninja por ID
    public NinjaDTO listarNinjaPorId(Long id){
      Optional<NinjaModel> ninjaBuscado = ninjaRepository.findById(id);
      return ninjaBuscado.map((ninjaModel -> ninjaMapper.mapModel(ninjaModel))).orElse(null);
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
    public NinjaDTO alterarNinjaPorId(NinjaDTO ninjaAtual, Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        if(ninjaModel.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.mapDTO(ninjaAtual);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.mapModel(ninjaSalvo);
        }else{
            return null;
        }
    }








}
