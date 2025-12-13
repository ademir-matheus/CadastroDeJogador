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
    @PostMapping("/criarJogador")
    public JogadorModel criaJogador (@RequestBody JogadorModel jogador) {
        return jogadorService.criaJogador(jogador);
    }

    // Lista todos os jogadores (CREATE)
    @GetMapping("/listarJogadores")
    public List<JogadorModel> listarJogadores () {
        return jogadorService.listarJogadores();
    }

    // Lista todos os jogadores por id
    @GetMapping("/listarJogadores/{id}")
    public JogadorModel listaJogadoresId (@PathVariable Long id) {
        return jogadorService.listarJogadoresPorId(id);
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
