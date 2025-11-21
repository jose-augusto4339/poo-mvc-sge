package br.com.sge.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="curso_ead")
public class CursoEAD extends Curso{

    @Column(name="plataforma")
    private String plataforma;

    public CursoEAD(){

    }

    public CursoEAD(Long id, String nome, String codigo, List<Aluno> alunos, int cargaHoraria, String plataforma) {
        super(id, nome, codigo, cargaHoraria, alunos);
        this.plataforma = plataforma;
    }

    @Override
    public void detalharCurso() {
        super.detalharCurso();
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}