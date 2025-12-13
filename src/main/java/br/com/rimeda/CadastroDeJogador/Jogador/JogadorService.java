package br.com.rimeda.CadastroDeJogador.Jogador;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<JogadorModel> listarJogadores() {
        return jogadorRepository.findAll();
    }


}
