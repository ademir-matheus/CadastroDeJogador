package br.com.rimeda.CadastroDeJogador.Clube;

public class ClubeMapper {

    public ClubeModel map (ClubeDTO clubeDTO){
        ClubeModel clubeModel = new ClubeModel();
        clubeModel.setId(clubeDTO.getId());
        clubeModel.setNome(clubeDTO.getNome());
        clubeModel.setJogadores(clubeDTO.getJogadores());

        return clubeModel;
    }

    public ClubeDTO map (ClubeModel clubeModel) {
        ClubeDTO clubeDTO = new ClubeDTO();
        clubeDTO.setId(clubeModel.getId());
        clubeDTO.setNome(clubeModel.getNome());
        clubeDTO.setJogadores(clubeModel.getJogadores());
        return clubeDTO;
    }

}
