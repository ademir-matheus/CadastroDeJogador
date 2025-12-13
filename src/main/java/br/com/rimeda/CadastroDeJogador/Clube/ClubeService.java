package br.com.rimeda.CadastroDeJogador.Clube;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubeService {

    private ClubeRepository clubeRepository;

    public ClubeService(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    public List<ClubeModel> listarClubes(){
        return clubeRepository.findAll();
    }

}
