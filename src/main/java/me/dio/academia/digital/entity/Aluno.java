package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data // getter e setter
@NoArgsConstructor // construtor vazio
@AllArgsConstructor // construtor
@Entity // cria a tabela no bd
@Table(name = "tb_alunos") // mudar o nome da tabela
@JsonIgnoreProperties({"hibernateLazeInitializer", "handler"}) // forma lazy
public class Aluno {

  @Id //id automatica
  @GeneratedValue(strategy = GenerationType.IDENTITY) // chave primaria
  private Long id;

  private String nome;

  @Column(unique = true) // transforma o atributo em coluna unica, não podendo repetir os dados
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  // Um aluno para varias avaliações
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) // relacionamento de tabelas - fectch é referente ao carregamento da lista
  @JsonIgnore // ignora erros do Json
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
