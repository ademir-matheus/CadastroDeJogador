package br.com.rimeda.CadastroDeJogador.Jogador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/jogador/Ui")
public class JogadorControllerUi {

    private final JogadorService jogadorService;
    public JogadorControllerUi(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping("/listarJogadores")
    public String listarJogadores (Model model) {
        List<JogadorDTO> jogadores = jogadorService.listarJogadores();
        model.addAttribute("jogadores", jogadores);
        return "listarJogadores";
    }

    @GetMapping("/deletarJogador/{id}")
    public String deletarJogador(@PathVariable Long id){
        jogadorService.deletarJogador(id);
        return "redirect:/jogador/Ui/listarJogadores";
    }

    @GetMapping("/listarJogador/{id}")
    public String listarJogadorPorId(@PathVariable Long id, Model model) {
        JogadorDTO jogadorDTO =  jogadorService.listarJogadoresPorId(id);
        if (jogadorDTO !=null) {
            model.addAttribute("jogador", jogadorDTO);
            return "detalhesJogador";
        } else {
            model.addAttribute("mensagem", "Jogador não encontrado");
            return "listarJogadores";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarJogador(Model model) {
        model.addAttribute("jogador", new JogadorDTO());
        return "criarJogador";
    }

    @PostMapping("/criarJogador")
    public String salvarJogador(@ModelAttribute JogadorDTO jogadorDTO, RedirectAttributes redirectAttributes) {
        jogadorService.criaJogador(jogadorDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Jogador cadastrado com sucesso!");
        return "redirect:/jogador/Ui/listarJogadores";
    }

}
