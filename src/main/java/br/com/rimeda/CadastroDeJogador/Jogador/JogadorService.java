package br.com.rimeda.CadastroDeJogador.Jogador;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    private JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<JogadorModel> listarJogadores() {
        return jogadorRepository.findAll();
    }

    public JogadorModel listarJogadoresPorId(Long id){
        Optional<JogadorModel> jogadorPorId = jogadorRepository.findById(id);
        return jogadorPorId.orElse(null);
    }

    public JogadorModel criaJogador (JogadorModel jogador) {
        return jogadorRepository.save(jogador);
    }

    public void deletarJogador (Long id) {
        jogadorRepository.deleteById(id);
    }

    public JogadorModel alterarJogador (Long id, JogadorModel jogadorAtualizado) {
        if (jogadorRepository.existsById(id)) {
            jogadorAtualizado.setId(id);
            return jogadorRepository.save(jogadorAtualizado);
        }
        return null;
    }

}
