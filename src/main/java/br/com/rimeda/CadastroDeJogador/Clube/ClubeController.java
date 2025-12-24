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
    public ClubeDTO criaClube (@RequestBody ClubeDTO clube) {
        return clubeService.criarClube(clube);
    }

    // Lista todos os jogadores (CREATE)
    @GetMapping("/listarClubes")
    public List<ClubeDTO> listarClubes () {
        return clubeService.listarClubes();
    }

    // Lista todos os jogadores por id
    @GetMapping("/listarClubes/{id}")
    public ClubeDTO listaClubesPorId (@PathVariable Long id) {
        return clubeService.listarClubesPorId(id);
    }

    // Deleta jogador (DELETE)
    @DeleteMapping("/deletarClube/{id}")
    public void deletarClube(Long id){
        clubeService.deletarClube(id);
    }

    @PutMapping("/alterClube/{id}")
    public ClubeDTO alterarClube (@PathVariable Long id, @RequestBody ClubeDTO clubeAtualizado) {
        return clubeService.alterarClube(id, clubeAtualizado);
    }

}
