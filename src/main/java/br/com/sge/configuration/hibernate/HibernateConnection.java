package br.com.sge.configuration.hibernate;

import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.reflections.Reflections;


import java.util.Set;

public class HibernateConnection {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            MetadataSources sources = new MetadataSources(registry);

            Reflections reflections = new Reflections("br.com.sge");
            Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);

            for (Class<?> entityClass : entities) {
                System.out.println("Registrando entidade: " + entityClass.getName());
                sources.addAnnotatedClass(entityClass);
            }

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
