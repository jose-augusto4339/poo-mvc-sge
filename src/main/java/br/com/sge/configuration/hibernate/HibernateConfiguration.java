package br.com.sge.configuration.hibernate;

import br.com.sge.model.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConfiguration {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(Administrador.class);
            sources.addAnnotatedClass(Aluno.class);
            sources.addAnnotatedClass(Avaliacao.class);
            sources.addAnnotatedClass(Curso.class);
            sources.addAnnotatedClass(CursoEAD.class);
            sources.addAnnotatedClass(CursoPresencial.class);
            sources.addAnnotatedClass(Professor.class);
            sources.addAnnotatedClass(Turma.class);

            return sources.buildMetadata().buildSessionFactory();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao construir SessionFactory", e);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}
