package br.com.rimeda.CadastroDeJogador;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class JogadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String instagram;
    private int idade;

    public JogadorModel() {
    }

    public JogadorModel(int idade, String instagram, String nome) {
        this.idade = idade;
        this.instagram = instagram;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
