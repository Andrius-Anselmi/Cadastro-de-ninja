package com.java.andrius.cadastrodeninjas.Ninjas.Model;

import com.java.andrius.cadastrodeninjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Entity transforma uma classe em uma entidade do Banco de Dados

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;


    //No código, o @ManyToOne dentro da classe NinjaModel, está dizendo ao
    // banco de dados: "Muitos objetos desta classe (Ninja) podem apontar para um
    // único objeto da classe referenciada (MissoesModel)."
    @ManyToOne
    //A gente criar uma Foreign Key(Chave Estrangeira) para que a tabela ninja
    //possa enxergar a tabela de missoes
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;
}
