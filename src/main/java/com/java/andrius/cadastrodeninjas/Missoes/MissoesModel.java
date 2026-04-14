package com.java.andrius.cadastrodeninjas.Missoes;

import com.java.andrius.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //OneToMany significa que uma missão pode ter varios ninjas(NinjaModel)
    // mappedBY: JPA entende que é o mesmo relacionamento e usa a FK que já existe no Ninja
    //Missão usa a mesma FK pra achar os ninjas dela
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;






}
