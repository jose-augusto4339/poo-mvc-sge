package br.com.sge.model.entity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="curso")
@Inheritance(strategy = InheritanceType.JOINED)
public class Curso implements IRelatorio{

    @Id
    @Column(name="curso_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "curso_seq_gen")
    @SequenceGenerator(name="curso_seq_gen", sequenceName = "seq_curso")
    private Long id;

    private String nome;

    private String codigo;

    private int cargaHoraria;

    public Curso() {
    }

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }


    @Override
    public void gerarRelatorio() {
        System.out.println(
                "Curso: " + this.getNome() + "\n" +
                "Código: " + this.getCodigo() + "\n" +
                "Carga horária: " + this.getCargaHoraria()
        );
    }

    public void detalharCurso(){
        System.out.println(
                "Curso: " + this.getNome() + "\n" +
                "Carga horária: " + this.getCargaHoraria()
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(nome, curso.nome) && Objects.equals(codigo, curso.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo);
    }
}
