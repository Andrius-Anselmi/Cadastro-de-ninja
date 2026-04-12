package com.java.andrius.cadastrodeninjas.Ninjas.Model;

import com.java.andrius.cadastrodeninjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

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
    private List<MissoesModel> missoes;

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
