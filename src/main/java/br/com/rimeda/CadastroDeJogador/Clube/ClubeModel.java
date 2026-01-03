package br.com.rimeda.CadastroDeJogador.Clube;

import br.com.rimeda.CadastroDeJogador.Jogador.JogadorModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_cadastro_clube")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClubeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    //@OneToMany -> Um clube para muitos jogadores e mappeia através do nome da coluna pré setada no ModelJogador.
    @OneToMany(mappedBy = "clube")
    @JsonIgnore
    private List<JogadorModel> jogadores;

}
