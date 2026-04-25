package com.java.andrius.cadastrodeninjas.Ninjas;


import com.java.andrius.cadastrodeninjas.Missoes.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel mapDTO(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setId(ninjaDTO.getId());


        return  ninjaModel;
    }

    public NinjaDTO mapModel(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());

        if(ninjaDTO.getMissoes() != null){
            MissoesModel missaoModel = new MissoesModel();
            missaoModel.setId(ninjaDTO.getMissoes().getId());
            missaoModel.setNome(ninjaDTO.getMissoes().getNome());
            missaoModel.setDificuldade(ninjaDTO.getMissoes().getDificuldade());
            ninjaModel.setMissoes(missaoModel);
        }
        return ninjaDTO;
    }
}
