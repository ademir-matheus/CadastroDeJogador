package br.com.rimeda.CadastroDeJogador.Jogador;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    private JogadorMapper jogadorMapper;
    private JogadorRepository jogadorRepository;

    public JogadorService(JogadorMapper jogadorMapper, JogadorRepository jogadorRepository) {
        this.jogadorMapper = jogadorMapper;
        this.jogadorRepository = jogadorRepository;
    }

    public List<JogadorDTO> listarJogadores() {
        List <JogadorModel> jogadoresModel = jogadorRepository.findAll();
        List<JogadorDTO> jogadorDTOS = new ArrayList<>();

            for (JogadorModel j : jogadoresModel) {
                jogadorDTOS.add(jogadorMapper.map(j));
            }

            return jogadorDTOS;

    }

    public JogadorDTO listarJogadoresPorId(Long id){
       JogadorModel jogadorModel = jogadorRepository.findById(id).orElse(null);
        return jogadorModel == null ? null : jogadorMapper.map(jogadorModel);
    }

    public JogadorDTO criaJogador (JogadorDTO jogadorDTO) {
        JogadorModel jogador = jogadorMapper.map(jogadorDTO);
        JogadorModel jogadorSalvo = jogadorRepository.save(jogador);
        return jogadorMapper.map(jogador);
    }

    public void deletarJogador (Long id) {
        jogadorRepository.deleteById(id);
    }

    public JogadorDTO alterarJogador (Long id, JogadorDTO jogadorAtualizado) {
        Optional<JogadorModel> jogadorExistente = jogadorRepository.findById(id);
        if (jogadorExistente.isPresent()) {
            JogadorModel jogadorModel = jogadorMapper.map(jogadorAtualizado);
            jogadorModel.setId(id);
            JogadorModel jogadorSalvo = jogadorRepository.save(jogadorModel);
            return jogadorAtualizado = jogadorMapper.map(jogadorSalvo);
        }
        return null;
    }

}
