package br.com.rimeda.CadastroDeJogador.Clube;

import br.com.rimeda.CadastroDeJogador.Jogador.JogadorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubeDTO {
    private Long id;
    private String nome;
    private List<JogadorModel> jogadores;
}
