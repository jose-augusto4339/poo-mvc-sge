package br.com.sge.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="administrdor")
public class Administrador extends User implements IAutenticacao{

    @Override
    public void autenticar(String login, String senha) {

    }
}
