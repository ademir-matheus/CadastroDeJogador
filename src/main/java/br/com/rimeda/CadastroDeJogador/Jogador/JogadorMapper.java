package br.com.rimeda.CadastroDeJogador.Jogador;

import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {

    public JogadorModel map (JogadorDTO jogadorDTO) {

        JogadorModel jogadorModel = new JogadorModel();
        jogadorModel.setId(jogadorDTO.getId());
        jogadorModel.setNome(jogadorDTO.getNome());
        jogadorModel.setIdade(jogadorDTO.getIdade());
        jogadorModel.setInstagram(jogadorDTO.getInstagram());
        jogadorModel.setClube(jogadorDTO.getClube());
        jogadorModel.setCorDePele(jogadorDTO.getCorDePele());
        jogadorModel.setStatusAtividade(jogadorDTO.getStatusAtividade());

        return jogadorModel;
    }

    public JogadorDTO map (JogadorModel jogadorModel){

        JogadorDTO jogadorDTO = new JogadorDTO();
        jogadorDTO.setId(jogadorModel.getId());
        jogadorDTO.setNome(jogadorModel.getNome());
        jogadorDTO.setIdade(jogadorModel.getIdade());
        jogadorDTO.setInstagram(jogadorModel.getInstagram());
        jogadorDTO.setClube(jogadorModel.getClube());
        jogadorDTO.setCorDePele(jogadorModel.getCorDePele());
        jogadorDTO.setStatusAtividade(jogadorModel.getStatusAtividade());
        return jogadorDTO;
    }


}
