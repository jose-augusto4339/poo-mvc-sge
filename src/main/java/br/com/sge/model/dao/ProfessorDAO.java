package br.com.sge.model.dao;

import br.com.sge.model.entity.Professor;

public class ProfessorDAO extends AbstractBaseDAO<Professor>{

    public ProfessorDAO(Class<Professor> entityClass) {
        super(entityClass);
    }
}
