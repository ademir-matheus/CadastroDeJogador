package br.com.rimeda.CadastroDeJogador.Jogador;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    // Criar jogador (CREATE)
    @PostMapping("/criarJogador")
    @Operation(
            summary = "Cria jogador",
            description = "Essa rota insere um jogador no banco de dados a partir dos dados enviados no corpo da requisição."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogador criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida. Verifique os dados enviados."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao tentar criar o jogador.")
    })
    public ResponseEntity<String> criaJogador(
            @Parameter(description = "Dados do jogador a ser criado (enviados no corpo da requisição).")
            @RequestBody JogadorDTO jogador
    ) {
        JogadorDTO jogadorCriado = jogadorService.criaJogador(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body("JOGADOR CRIADO! ID: " + jogadorCriado.getId());
    }

    // Listar jogadores (READ)
    @GetMapping("/listarJogadores")
    @Operation(
            summary = "Lista jogadores",
            description = "Essa rota retorna a lista de todos os jogadores cadastrados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de jogadores retornada com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao listar jogadores.")
    })
    public ResponseEntity<List<JogadorDTO>> listarJogadores() {
        List<JogadorDTO> jogadorDTOList = jogadorService.listarJogadores();
        return ResponseEntity.ok(jogadorDTOList);
    }

    // Lista jogador por id (READ)
    @GetMapping("/listarJogadores/{id}")
    @Operation(
            summary = "Lista jogador por id",
            description = "Essa rota retorna os dados de um jogador específico a partir do ID informado no caminho."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jogador encontrado e retornado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Jogador não encontrado para o ID informado."),
            @ApiResponse(responseCode = "400", description = "ID inválido (formato incorreto)."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar jogador.")
    })
    public ResponseEntity<?> listaJogadoresPorId(
            @Parameter(description = "ID do jogador a ser buscado.", example = "1")
            @PathVariable Long id
    ) {
        JogadorDTO jogadorExistente = jogadorService.listarJogadoresPorId(id);

        if (jogadorExistente != null) {
            return ResponseEntity.ok(jogadorExistente); // 200
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("JOGADOR COM O ID: " + id + " NÃO ENCONTRADO!");
    }

    // Alterar jogador (UPDATE)
    @PutMapping("/alterarJogador/{id}")
    @Operation(
            summary = "Altera jogador",
            description = "Essa rota atualiza os dados de um jogador existente a partir do ID informado e do corpo da requisição."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jogador atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Jogador não encontrado para o ID informado."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida. Verifique os dados enviados."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao atualizar jogador.")
    })
    public ResponseEntity<?> alterarJogador(
            @Parameter(description = "ID do jogador a ser atualizado.", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Novos dados do jogador (enviados no corpo da requisição).")
            @RequestBody JogadorDTO jogadorAtualizado
    ) {
        JogadorDTO jogadorExistente = jogadorService.listarJogadoresPorId(id);

        if (jogadorExistente != null) {
            JogadorDTO jogadorAlterado = jogadorService.alterarJogador(id, jogadorAtualizado);
            return ResponseEntity.ok(jogadorAlterado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("JOGADOR COM O ID: " + id + " NÃO ENCONTRADO!");
    }

    // Deletar jogador (DELETE)
    @DeleteMapping("/deletarJogador/{id}")
    @Operation(
            summary = "Deleta jogador",
            description = "Essa rota remove um jogador do banco de dados a partir do ID informado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jogador deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Jogador não encontrado para o ID informado."),
            @ApiResponse(responseCode = "400", description = "ID inválido (formato incorreto)."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao deletar jogador.")
    })
    public ResponseEntity<String> deletarJogador(
            @Parameter(description = "ID do jogador a ser deletado.", example = "1")
            @PathVariable Long id
    ) {
        JogadorDTO jogadorDTO = jogadorService.listarJogadoresPorId(id);

        if (jogadorDTO != null) {
            jogadorService.deletarJogador(id);
            return ResponseEntity.ok("JOGADOR COM O ID: " + id + " DELETADO");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("JOGADOR COM O ID: " + id + " NÃO ENCONTRADO!");
    }
}