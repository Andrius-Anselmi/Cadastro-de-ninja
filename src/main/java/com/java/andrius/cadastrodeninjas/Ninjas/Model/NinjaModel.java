package com.java.andrius.cadastrodeninjas.Ninjas.Model;

import com.java.andrius.cadastrodeninjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;

//Entity transforma uma classe em uma entidade do Banco de Dados
@Entity
@Table(name = "tb_cadastro")
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

    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
