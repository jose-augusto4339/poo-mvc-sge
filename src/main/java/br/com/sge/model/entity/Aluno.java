package br.com.sge.model.entity;

import jakarta.persistence.*;

import java.util.List;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "aluno_curso", joinColumns = {@JoinColumn(name = "aluno_id")}, inverseJoinColumns = {@JoinColumn(name = "curso_id")})
    private List<Curso> cursos;

    public Aluno() {
    }

    public Aluno(Long id, String matricula, List<Curso> cursos) {
        this.id = id;
        this.matricula = matricula;
        this.cursos = cursos;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println(
                "Nome do aluno: " + this.getNome() + "\n" +
                "Matricula: " + this.getMatricula() + "\n" +
                "Curso: " + this.getCursos()
        );
    }

    @Override
    public void autenticar(String login, String senha) {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
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
