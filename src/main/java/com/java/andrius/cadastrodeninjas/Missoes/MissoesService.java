package com.java.andrius.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;

    MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel criarMissao(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissaoPorId(Long id){
        Optional<MissoesModel> missaoBuscada = missoesRepository.findById(id);
        return missaoBuscada.orElse(null);
    }

    public Boolean deletarMissaoPorId(Long id){
        if(missoesRepository.existsById(id)){
            missoesRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public MissoesModel alteraMissaoPorId(Long id, MissoesModel missaoAtualizada){
        if(missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }else{
            return missaoAtualizada;
        }
    }


}
