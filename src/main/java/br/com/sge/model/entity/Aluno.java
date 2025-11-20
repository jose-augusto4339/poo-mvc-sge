package br.com.sge.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="aluno")
public class Aluno extends User implements IAutenticacao, IRelatorio{

    @Id
    @Column(name="aluno_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "aluno_seq_gen")
    @SequenceGenerator(name="aluno_seq_gen", sequenceName = "seq_aluno")
    private Long id;

    @Column(name = "matricula")
    private String matricula;

    @OneToMany
    private Curso curso;

    public Aluno() {
    }

    public Aluno(String nome, String matricula, Curso curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println(
                "Nome do aluno: " + this.getNome() + "\n" +
                "Matricula: " + this.getMatricula() + "\n" +
                "Curso: " + this.getCurso()
        );
    }

    @Override
    public void autenticar(String login, String senha) {

    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(nome, aluno.nome) && Objects.equals(matricula, aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, matricula);
    }
}
