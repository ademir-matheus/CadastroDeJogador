package br.com.rimeda.CadastroDeJogador.Clube;

import br.com.rimeda.CadastroDeJogador.Jogador.JogadorModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro_missao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "clube")
    private List<JogadorModel> jogadores;

}
