package br.com.rimeda.CadastroDeJogador.Jogador;

import br.com.rimeda.CadastroDeJogador.Clube.ClubeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "clube")
public class JogadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column(unique = true, name = "instagram")
    private String instagram;

    @Column (name = "idade")
    private int idade;

    @Column (name = "cor_de_pele")
    private String corDePele;

    @Column (name = "status_atividade")
    private String statusAtividade;

    @Column (name = "imagem_jogador")
    private String imagemJogador;

    // @ManyToOne -> Muitos jogadores para um clube.
    @ManyToOne
    // @JoinColumn -> junta as tabelas através do primary key e nomeia de acordo com name.
    @JoinColumn(name = "clube_id")
    private ClubeModel clube;

}
