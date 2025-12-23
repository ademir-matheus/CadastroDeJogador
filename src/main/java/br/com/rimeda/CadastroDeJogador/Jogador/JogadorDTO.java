package br.com.rimeda.CadastroDeJogador.Jogador;

import br.com.rimeda.CadastroDeJogador.Clube.ClubeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorDTO {
    private Long id;
    private String nome;
    private String instagram;
    private int idade;
    private ClubeModel clube;
    private String corDePele;
}
