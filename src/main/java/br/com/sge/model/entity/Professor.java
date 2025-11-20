package br.com.sge.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="professor")
public class Professor extends User implements IAutenticacao, IRelatorio{

    private String especialidade;

    private String registro;

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
