package br.com.rimeda.CadastroDeJogador.Clube;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clube")
public class ClubeController {

    private final ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    // Criar jogador (CREATE)
    @PostMapping("/criarClube")
    public ResponseEntity<String> criaClube (@RequestBody ClubeDTO clube) {
        ClubeDTO clubeCriado = clubeService.criarClube(clube);
        return ResponseEntity.status(HttpStatus.CREATED).body("CLUBE CRIADO!");
    }

    // Lista todos os jogadores (CREATE)
    @GetMapping("/listarClubes")
    public ResponseEntity<List<ClubeDTO>> listarClubes () {
        List<ClubeDTO> clubeDTOList = clubeService.listarClubes();
        return ResponseEntity.ok(clubeDTOList);
    }

    // Lista todos os jogadores por id
    @GetMapping("/listarClubes/{id}")
    public ResponseEntity<?> listaClubesPorId (@PathVariable Long id) {
        ClubeDTO clubeExistente = clubeService.listarClubesPorId(id);
        return (clubeExistente != null) ? ResponseEntity.ok(clubeExistente) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("JOGADOR COM O ID: "+ id +" NÃO ENCONTRADO!");
    }

    @PutMapping("/alterClube/{id}")
    public ResponseEntity<?> alterarClube (@PathVariable Long id, @RequestBody ClubeDTO clubeAtualizado) {
        ClubeDTO clubeExistente = clubeService.listarClubesPorId(id);
        if (clubeExistente != null) {
            ClubeDTO clubeAlterado = clubeService.alterarClube(id, clubeAtualizado);
            return ResponseEntity.ok(clubeAlterado);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("JOGADOR COM O ID: "+ id +" NÃO ENCONTRADO!");
        }
    }

    // Deleta jogador (DELETE)
    @DeleteMapping("/deletarClube/{id}")
    public ResponseEntity<String> deletarClube(Long id){
        ClubeDTO clubeExistente = clubeService.listarClubesPorId(id);
        return (clubeExistente != null) ? ResponseEntity.ok("JOGADOR DELETADO!") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("JOGADOR COM O ID: "+ id +" NÃO ENCONTRADO!");
    }

}
