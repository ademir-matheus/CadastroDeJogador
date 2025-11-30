package br.com.rimeda.CadastroDeJogador.Jogador;

import br.com.rimeda.CadastroDeJogador.Clube.ClubeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String instagram;

    private int idade;

    // @ManyToOne -> Muitos jogadores para um clube.
    @ManyToMany
    // @JoinColumn -> junta as tabelas através do primary key e nomeia de acordo com name.
    @JoinColumn(name = "clube_id")
    private ClubeModel clube;

}
