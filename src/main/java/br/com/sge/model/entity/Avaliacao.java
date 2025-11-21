package br.com.sge.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="avaliacao")
public class Avaliacao {

    @Id
    @Column(name="nota_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "nota_seq_gen")
    @SequenceGenerator(name="nota_seq_gen", sequenceName = "seq_nota")
    private Long id;

    @Column(name="nota")
    private int nota;

    @Column(name="nota")
    private String descricao;

    @Column(name="aluno_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Aluno aluno;

    @Column(name="turma_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Turma turma;

    public Avaliacao() {
    }

    public void atribuitNote(int nota){
        if(nota >= 0 && nota <= 10){
            this.nota = nota;
        }else {
            throw new IllegalArgumentException("O valor para a nota deve estar entre 0 e 10");
        }
    }

    public Avaliacao(int nota, String descricao) {
        this.nota = nota;
        this.descricao = descricao;
    }

    public int getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return nota == avaliacao.nota && Objects.equals(descricao, avaliacao.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nota, descricao);
    }
}
