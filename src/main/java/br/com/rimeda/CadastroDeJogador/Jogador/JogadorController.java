package br.com.rimeda.CadastroDeJogador.Jogador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    // Criar jogador (CREATE)
    @PostMapping("/criarJogador")
    public ResponseEntity<String> criaJogador (@RequestBody JogadorDTO jogador) {
        JogadorDTO jogadorCriado = jogadorService.criaJogador(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body("JOGADOR CRIADO! ID: " + jogadorCriado.getId());
    }

    @GetMapping("/listarJogadores")
    public ResponseEntity<List<JogadorDTO>> listarJogadores () {
        List<JogadorDTO> jogadorDTOList = jogadorService.listarJogadores();
        return ResponseEntity.ok(jogadorDTOList);
    }

    // Lista todos os jogadores por id
    @GetMapping("/listarJogadores/{id}")
    public ResponseEntity<?> listaJogadoresDVId (@PathVariable Long id) {
        JogadorDTO jogadorExistente = jogadorService.listarJogadoresPorId(id);
        return (jogadorExistente != null) ? ResponseEntity.status(HttpStatus.FOUND).body(jogadorExistente) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("JOGADOR COM O ID: "+ id +" NÃO ENCONTRADO!");
    }

    @PutMapping("/alterarJogador/{id}")
    public ResponseEntity<?> alterarJogador (@PathVariable Long id, @RequestBody JogadorDTO jogadorAtualizado) {
        JogadorDTO jogadorExistente = jogadorService.listarJogadoresPorId(id);
        if (jogadorExistente != null) {
            JogadorDTO jogadorAlterado = jogadorService.alterarJogador(id, jogadorAtualizado);
            return ResponseEntity.ok(jogadorAlterado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("JOGADOR COM O ID: "+ id +" NÃO ENCONTRADO!");
        }

    }

    // Deleta jogador (DELETE)
    @DeleteMapping("/deletarJogador/{id}")
    public ResponseEntity<String> deletarJogador(@PathVariable Long id){
        jogadorService.deletarJogador(id);
        return ResponseEntity.ok("JOGADOR COM O ID: "+id+" DELETADO");
    }

}
