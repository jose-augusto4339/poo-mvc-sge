package br.com.sge.model.entity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="curso")
@Inheritance(strategy = InheritanceType.JOINED)
public class Curso implements IRelatorio{

    @Id
    @Column(name="curso_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq_gen")
    @SequenceGenerator(name="curso_seq_gen", sequenceName = "seq_curso")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="codigo")
    private String codigo;

    @Column(name="carga_horaria")
    private int cargaHoraria;

    @ManyToMany(mappedBy = "cursos")
    private List<Aluno> alunos;


    public Curso() {
    }

    public Curso(Long id, String nome, String codigo, int cargaHoraria, List<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.alunos = alunos;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
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
