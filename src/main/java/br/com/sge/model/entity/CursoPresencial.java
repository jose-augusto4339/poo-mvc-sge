package br.com.sge.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="curso_presencial")
public class CursoPresencial extends Curso{

    @Column(name="sala")
    private String sala;

    public CursoPresencial(){

    }

    public CursoPresencial(Long id, String nome, String codigo, List<Aluno> alunos, int cargaHoraria, String plataforma) {
        super(id, nome, codigo, cargaHoraria, alunos);
        this.sala = sala;
    }

    @Override
    public void detalharCurso() {
        super.detalharCurso();
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
