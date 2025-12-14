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
    @PostMapping("/criarClube")
    public ClubeModel criaClube (@RequestBody ClubeModel clube) {
        return clubeService.criarClube(clube);
    }

    // Lista todos os jogadores (CREATE)
    @GetMapping("/listarClubes")
    public List<ClubeModel> listarClubes () {
        return clubeService.listarClubes();
    }

    // Lista todos os jogadores por id
    @GetMapping("/listarClubes/{id}")
    public ClubeModel listaClubesPorId (@PathVariable Long id) {
        return clubeService.listarClubesPorId(id);
    }

    // Altera jogador (UPDATE)
    @PutMapping("/alterar")
    public String alterarClube () {
        return "Altera Clube";
    }

    // Deleta jogador (DELETE)
    @DeleteMapping("/deletarClube/{id}")
    public void deletarClube(Long id){
        clubeService.deletarClube(id);
    }

    @PutMapping("/alterClube/{id}")
    public ClubeModel alterarClube (@PathVariable Long id, @RequestBody ClubeModel clubeAtualizado) {
        return clubeService.alterarClube(id, clubeAtualizado);
    }

}
