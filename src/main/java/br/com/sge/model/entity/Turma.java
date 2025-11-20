package br.com.sge.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="turma")
public class Turma {

    private String codigo;

    private Professor professor;

    private Curso curso;

    private List<Aluno> listaAlunos = new ArrayList<Aluno>();

    public Turma() {
    }

    public Turma(String codigo, Professor professor, List<Aluno> listaAlunos) {
        this.codigo = codigo;
        this.professor = professor;
        this.listaAlunos = listaAlunos;
    }

    public void geraResumoTurma(){
        System.out.println(
                "Professor: " + this.getProfessor().getNome() + "\n" +
                "Curso: " + this.getCurso().getNome() + "\n" +
                "Alunos matriculados: " + this.getListaAlunos().size()
        );
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(codigo, turma.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}

