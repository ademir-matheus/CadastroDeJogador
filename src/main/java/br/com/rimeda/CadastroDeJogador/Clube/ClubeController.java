package br.com.rimeda.CadastroDeJogador.Clube;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClubeController {

    @GetMapping("/clube")
    public String boasVindasClube(){
        return "Bem vindo ao controller de Clube!";
    }

}
