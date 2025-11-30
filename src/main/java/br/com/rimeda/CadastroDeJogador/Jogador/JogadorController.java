package br.com.rimeda.CadastroDeJogador.Jogador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class JogadorController {

    // Cria primeira rota;
    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Bem vindo a API de cadastro de jogador!";
    }
}
