package br.com.rimeda.CadastroDeJogador.Clube;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubeService {

    private ClubeRepository clubeRepository;

    public ClubeService(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    public List<ClubeModel> listarClubes(){
        return clubeRepository.findAll();
    }

    public ClubeModel listarClubesPorId (Long id){
        Optional<ClubeModel> clubePorId = clubeRepository.findById(id);
        return clubePorId.orElse(null);
    }

    public ClubeModel criarClube (ClubeModel clube){
        return clubeRepository.save(clube);
    }

    public void deletarClube (Long id) {
        clubeRepository.deleteById(id);
    }

    public ClubeModel alterarClube (Long id, ClubeModel clubeAtualizado) {
        if (clubeRepository.existsById(id)) {
            clubeAtualizado.setId(id);
            return clubeRepository.save(clubeAtualizado);
        }
        return null;
    }

}
