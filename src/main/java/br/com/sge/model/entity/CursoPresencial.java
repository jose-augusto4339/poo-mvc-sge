package br.com.sge.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="curso_presencial")
public class CursoPresencial extends Curso{

    private String sala;

    public CursoPresencial(){

    }

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String sala) {
        super(nome, codigo, cargaHoraria);
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
