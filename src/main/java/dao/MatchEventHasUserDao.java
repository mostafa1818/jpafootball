package dao;

import entity.MatchEventHasUser;

import javax.persistence.EntityManager;

public class MatchEventHasUserDao extends AbstractJpaDao<MatchEventHasUser,Integer>{
    public MatchEventHasUserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<MatchEventHasUser> getEntityClass() {
        return MatchEventHasUser.class;
    }
}
