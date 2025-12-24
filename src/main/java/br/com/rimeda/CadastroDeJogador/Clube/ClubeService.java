package br.com.rimeda.CadastroDeJogador.Clube;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClubeService {

    private ClubeRepository clubeRepository;
    private ClubeMapper clubeMapper;

    public ClubeService(ClubeRepository clubeRepository, ClubeMapper clubeMapper) {
        this.clubeRepository = clubeRepository;
        this.clubeMapper = clubeMapper;
    }

    public List<ClubeDTO> listarClubes(){
        List<ClubeModel> clubeModels = clubeRepository.findAll();
        List<ClubeDTO> clubeDTOS = new ArrayList<>();

        for (ClubeModel c : clubeModels) {
            clubeDTOS.add(clubeMapper.map(c));
        }

        return clubeDTOS;
    }

    public ClubeDTO listarClubesPorId (Long id){
        ClubeModel clubePorId = clubeRepository.findById(id).orElse(null);
        return (clubePorId == null) ? null : clubeMapper.map(clubePorId);
    }

    public ClubeDTO criarClube (ClubeDTO clubeDTO){
        ClubeModel clubeModel = clubeMapper.map(clubeDTO);
        ClubeModel clubeSalvo = clubeRepository.save(clubeModel);
        return clubeMapper.map(clubeSalvo);
    }

    public void deletarClube (Long id) {
        clubeRepository.deleteById(id);
    }

    public ClubeDTO alterarClube (Long id, ClubeDTO clubeAtualizado) {
        Optional <ClubeModel> clubeExistente = clubeRepository.findById(id);
        if (clubeExistente.isPresent()) {
            ClubeModel clubeModel = clubeMapper.map(clubeAtualizado);
            clubeModel.setId(id);
            ClubeModel clubeSalvo = clubeRepository.save(clubeModel);
            return clubeMapper.map(clubeSalvo);
        }
        return null;
    }

}
