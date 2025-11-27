package br.com.sge.model.dao;

import br.com.sge.model.entity.Aluno;

public class AlunoDAO extends AbstractBaseDAO<Aluno>{

    public AlunoDAO(Class<Aluno> entityClass) {
        super(entityClass);
    }
}
