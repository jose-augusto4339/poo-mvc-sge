# Projeto Java com arquitetura MVC
Este projeto tem como objetivo o execicio da construção de projetos utlizando a arquitetura MVC, além disso, a utilização do Framework Hibernate como ORM e do padrão DAO.

## Estrutura do projeto
Seguindo os princípios da arquitetura MVC as classes responsáveis pelas entidades estão contidas no pacote model.entity.

src
├── main
│   ├── java
│   │   └── br
│   │       └── com
│   │           └── sge
│   │               ├── Main.java
│   │               └── model
│   │                   ├── dao
│   │                   ├── entity
│   │                   │   ├── Administrador.java
│   │                   │   ├── Aluno.java
│   │                   │   ├── Avaliacao.java
│   │                   │   ├── CursoEAD.java
│   │                   │   ├── Curso.java
│   │                   │   ├── CursoPresencial.java
│   │                   │   ├── IAutenticacao.java
│   │                   │   ├── IRelatorio.java
│   │                   │   ├── Professor.java
│   │                   │   ├── Turma.java
│   │                   │   └── User.java
│   │                   └── service
│   └── resources
│       └── hibernate.properties
└── test
    └── java
