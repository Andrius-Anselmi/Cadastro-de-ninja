package com.java.andrius.cadastrodeninjas.Ninjas;

import com.java.andrius.cadastrodeninjas.Missoes.MissoesDTO;
import com.java.andrius.cadastrodeninjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private String imgUrl;
    private String rank;
    private MissoesDTO missoes;

}
