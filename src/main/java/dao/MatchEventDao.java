package dao;

import entity.MatchEvent;

import javax.persistence.EntityManager;

public class MatchEventDao extends AbstractJpaDao<MatchEvent,Integer>{
    public MatchEventDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<MatchEvent> getEntityClass() {
        return MatchEvent.class;
    }
}
