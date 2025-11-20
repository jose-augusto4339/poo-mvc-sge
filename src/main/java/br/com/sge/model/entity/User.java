package br.com.sge.model.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User {

    protected String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
