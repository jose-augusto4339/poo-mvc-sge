package br.com.sge.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="administrdor")
public class Administrador extends User implements IAutenticacao{

    @Id
    @Column(name="administrador_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administrador_seq_gen")
    @SequenceGenerator(name="administrador_seq_gen", sequenceName = "seq_administrador")
    private Long id;

    @Override
    public void autenticar(String login, String senha) {

    }
}
