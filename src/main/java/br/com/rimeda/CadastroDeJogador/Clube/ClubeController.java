package br.com.rimeda.CadastroDeJogador.Clube;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clube")
public class ClubeController {

    private ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @GetMapping("/clube")
    public String boasVindasClube(){
        return "Bem vindo ao controller de Clube!";
    }

    // Criar jogador (CREATE)
    @PostMapping("/criar")
    public String criaClube () {
        return "Clube criado";
    }

    // Lista todos os jogadores (CREATE)
    @GetMapping("/listarClubes")
    public List<ClubeModel> listarClubes () {
        return clubeService.listarClubes();
    }

    // Lista todos os jogadores por id
    @GetMapping("/todosid")
    public String listaClubesId () {
        return "Mostra todos os Clubes por id";
    }

    // Altera jogador (UPDATE)
    @PutMapping("/alterar")
    public String alterarClube () {
        return "Altera Clube";
    }

    // Deleta jogador (DELETE)
    @DeleteMapping("/deleta")
    public String deletaClube(){
        return "deleta Clube";
    }

}
