package br.com.sge.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="avaliacao")
public class Avaliacao {

    private int nota;

    private String descricao;

    private Aluno aluno;

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
