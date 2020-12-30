package dao;

import entity.Staduim;

import javax.persistence.EntityManager;

public class StaduimDao extends AbstractJpaDao<Staduim,Integer>{
    public StaduimDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Staduim> getEntityClass() {
        return Staduim.class;
    }
}
