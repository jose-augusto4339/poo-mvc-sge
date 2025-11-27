package br.com.sge.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="professor")
public class Professor extends User implements IAutenticacao, IRelatorio{

    @Id
    @Column(name="professor_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor_seq_gen")
    @SequenceGenerator(name="professor_seq_gen", sequenceName = "seq_professor")
    private Long id;

    @Column(name="especialidade")
    private String especialidade;

    @Column(name="registro")
    private String registro;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "professor_turma", joinColumns = {@JoinColumn(name = "professor_id")}, inverseJoinColumns = {@JoinColumn(name = "turma_id")})
    private List<Turma> turmas;

    public Professor() {
    }

    public Professor(String nome, String especialidade, String registro) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println(
                "Nome do professor: " + this.getNome() + "\n" +
                "Especialidade: " + this.getEspecialidade() + "\n" +
                "Registro: " + this.getRegistro()
        );
    }

    @Override
    public void autenticar(String login, String senha) {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(nome, professor.nome) && Objects.equals(registro, professor.registro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, registro);
    }

}
