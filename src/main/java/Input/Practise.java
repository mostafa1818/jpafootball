package Input;

import entity.City;
import entity.Contract;
import entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class Practise {

    public void maxSalary(EntityManager entityManager)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = cb.createQuery(Object[].class);
        Root<Contract> fromContract = criteriaQuery.from(Contract.class);


        Subquery<Double> sq1 = criteriaQuery.subquery(Double.class);
        Root<Contract> subqueryContract = sq1.from(Contract.class);
        sq1.select(cb.max(subqueryContract.<Double> get("salary")));

        Predicate predicate=cb.and(
                cb.equal(fromContract.get("salary"),sq1),
                cb.equal(fromContract.get("user").get("userType"),"coach")
        );

        criteriaQuery.multiselect(fromContract.get("user").get("firstName"),fromContract.get("user").get("lastName"),fromContract.get("salary") );
        criteriaQuery.where(predicate);
     //   criteriaQuery.groupBy(fromTeam.get("name"),fromTeam.get("season"));
        TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);
        List<Object[]> list = query.getResultList();
        for(Object[] temp : list) {
            System.out.println(temp[0] + " , " + temp[1]+ " , " + temp[2]);

    }
    }
    public void listPlayer(EntityManager entityManager)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = cb.createQuery(Object[].class);
        Root<Contract> fromContract = criteriaQuery.from(Contract.class);


        Subquery<Double> sq1 = criteriaQuery.subquery(Double.class);
        Root<Contract> subqueryContract = sq1.from(Contract.class);
        sq1.select(cb.max(subqueryContract.<Double> get("salary")));
        sq1.where( cb.equal(fromContract.get("user").get("userType"),"player"));
        sq1.groupBy(subqueryContract.get("season"));



        criteriaQuery.multiselect(fromContract.get("user")
                .get("firstName"),fromContract.get("user").get("lastName"),fromContract.get("salary") );
        criteriaQuery.where(  cb.equal(fromContract.get("salary"),sq1));

        TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);
        List<Object[]> list = query.getResultList();
        for(Object[] temp : list) {
            System.out.println(temp[0] + " , " + temp[1]+ " , " + temp[2]);
        }
    }
    public void listCity(EntityManager entityManager)
    {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = cb.createQuery(Object[].class);
        Root<Team> fromTeam = criteriaQuery.from(Team.class);
        Join<Team,City> cityJoin = fromTeam.join("city");
        criteriaQuery.multiselect(cityJoin.get("name"),cb.count(fromTeam.get("name")));
        criteriaQuery.groupBy(cityJoin.get("name"));


        TypedQuery<Object[]> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Object[]> list = typedQuery.getResultList();
        for(Object[] temp : list) {
            System.out.println(temp[0] + " = " + temp[1]);
        }


    }
    public void countScore(EntityManager entityManager)
    {


    }
    public void  champion(EntityManager entityManager)
    {


    }


}
