package br.com.sge;

import br.com.sge.configuration.hibernate.HibernateConnection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HibernateConnection.getSession().close();


        HibernateConnection.shutdown();
    }
}