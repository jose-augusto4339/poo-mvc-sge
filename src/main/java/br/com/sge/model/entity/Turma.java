package br.com.sge.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="turma")
public class Turma {

    @Id
    @Column(name="turma_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turma_seq_gen")
    @SequenceGenerator(name="turma_seq_gen", sequenceName = "seq_turma")
    private Long id;

    @Column(name="codigo")
    private String codigo;

    @ManyToMany(mappedBy = "turmas")
    private List<Professor> professores;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "turma_aluno", joinColumns = {@JoinColumn(name = "turma_id")}, inverseJoinColumns = {@JoinColumn(name = "aluno_id")})
    private List<Aluno> listaAlunos = new ArrayList<Aluno>();

    public Turma() {
    }

    public Turma(Long id, String codigo, List<Professor> professores, List<Aluno> listaAlunos) {
        this.id = id;
        this.codigo = codigo;
        this.professores = professores;
        this.listaAlunos = listaAlunos;
    }

    public void geraResumoTurma(){

        System.out.println("============================================");
        System.out.println("Professores: ");
        for(Professor prof : this.getProfessores()){
            System.out.println("Nome: " + prof.getNome());
            System.out.println("Registro: " + prof.getRegistro());
        }

        System.out.println("============================================");
        System.out.println("Alunos: ");
        for(Aluno aluno : this.getListaAlunos()){
            System.out.println("Nome: " + aluno.getNome());
        }

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
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

