package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
@JsonIgnoreProperties({"hibernateLazeInitializer", "handler"})
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // varias avaliacoes para um aluno
    @ManyToOne(cascade = CascadeType.ALL) // cascade o que acontecer em avaliacao, vai repercutir em aluno
    @JoinColumn(name = "aluno_id") //
    private Aluno aluno;

    private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

    @Column(name = "peso_atual")
    private double peso;

    @Column(name = "altura_atual")
    private double altura;

}
