package dao;

import entity.MatchDeatail;

import javax.persistence.EntityManager;

public class MatchDeatailDao extends AbstractJpaDao<MatchDeatail,Integer> {
    public MatchDeatailDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<MatchDeatail> getEntityClass() {
        return MatchDeatail.class;
    }
}
