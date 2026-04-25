package com.java.andrius.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper){
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missaoSalva = missoesMapper.mapDTO(missoesDTO);
        missoesRepository.save(missaoSalva);
        return missoesMapper.mapModel(missaoSalva);
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoesModels = missoesRepository.findAll();
        return missoesModels.stream().map((missoesMapper::mapModel)).toList();
    }

    public MissoesDTO listarMissaoPorId(Long id){
        Optional<MissoesModel> missaoBuscada = missoesRepository.findById(id);
        return missaoBuscada.map((missoesModel -> missoesMapper.mapModel(missoesModel))).orElse(null);
    }

    public Boolean deletarMissaoPorId(Long id){
        if(missoesRepository.existsById(id)){
            missoesRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public MissoesDTO alteraMissaoPorId(Long id, MissoesDTO missaoAtualizada){
        Optional<MissoesModel> missaoBuscada = missoesRepository.findById(id);
        if(missaoBuscada.isPresent()){
            MissoesModel missaoNova = missoesMapper.mapDTO(missaoAtualizada);
            missaoNova.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoNova);
            return missoesMapper.mapModel(missaoSalva);
        }else{
            return null;
        }
    }


}
