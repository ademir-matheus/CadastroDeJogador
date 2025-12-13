package br.com.rimeda.CadastroDeJogador.Jogador;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    // Cria primeira rota;
    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Bem vindo a API de cadastro de jogador!";
    }

    // Criar jogador (CREATE)
    @PostMapping("/criarjogador")
    public String criaJogador () {
        return "Jogador criado";
    }

    // Lista todos os jogadores (CREATE)
    @GetMapping("/listarJogadores")
    public List<JogadorModel> listarJogadores () {
        return jogadorService.listarJogadores();
    }

    // Lista todos os jogadores por id
    @GetMapping("/todosidjogador")
    public String listaJogadoresId () {
        return "Mostra todos os jogadores por id";
    }

    // Altera jogador (UPDATE)
    @PutMapping("/alterarjogador")
    public String alterarJogador () {
        return "Altera jogador";
    }

    // Deleta jogador (DELETE)
    @DeleteMapping("/deletajogador")
    public String deletaJogador(){
        return "deleta jogador";
    }

}
