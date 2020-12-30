import Input.*;
import dao.*;
import entity.*;

import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class App {
 

    private static InputUserFirstPart inputUserFirstPart;
    private static InputUserSecondPart inputUserSecondPart;

    private static City[] cities = new City[10];
    private static Contract[] contracts = new Contract[10];
    private static MatchDeatail[] matches = new MatchDeatail[10];
    private static MatchEvent[] matchEvents = new MatchEvent[10];
    private static MatchEventHasUser[] matchEventHasUsers = new MatchEventHasUser[10];
    private static Staduim[] staduims = new Staduim[10];
    private static Team[] teams = new Team[10];
    private static User[] users = new User[20];

    private static CityDao cityDao;
    private static ContractDao contractDao;
    private static MatchDeatailDao matchDeatailDao;
    private static MatchEventDao matchEventDao;
    private static MatchEventHasUserDao matchEventHasUserDao;
    private static StaduimDao staduimDao;
    private static TeamDao teamDao;
    private static UserDao userDao;

    private static final Integer CHECK_CITY_ID = 1;//problem
    private static final Integer CHECK_CON_ID = 1;//problem
    private static final Integer CHECK_MATCH_ID = 1;//problem
    private static final Integer CHECK_MATCHE_ID = 1;//problem
    private static final Integer CHECK_MATCHEHASU_ID = 1;//problem
    private static final Integer CHECK_STA_ID = 1;//problem
    private static final Integer CHECK_TEAM_ID = 1;//problem
    private static final Integer CHECK_USER_ID = 1;//problem

    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static DateFormat yearFormat = new SimpleDateFormat("yyyy//");
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        initializeDao(entityManager);
        entityManager.getTransaction().begin();
         if (teamDao.load(CHECK_TEAM_ID) == null)
         {initializeData();}

         deleteData();
         updateData();
        entityManager.flush();
        showData();

        entityManager.getTransaction().commit();
        entityManager.close();
        JPAUtil.shutdown();
    }

    public static void initializeData() {









        /////////////////////////////////////
        /*---------------------cities input----------------------- */
        cities[0]=createCity("tehran");
        cities[1]=createCity("tabriz");
        cities[2]=createCity("mashhad");
        cities[3]=createCity("esfahan");
        cities[4]=createCity("karaj");
        cities[5]=createCity("rasht");

        /*---------------------contracts input--------------------- */
        try {
            contracts[0]=createContract(dateFormat.parse("00/00/2018"),"1 YEARS",3000.0);
        } catch (ParseException e) {   e.printStackTrace();  }

        try {
            contracts[1]=createContract(dateFormat.parse("00/00/2017"),"2 YEARS",4400.0);
        } catch (ParseException e) {   e.printStackTrace();  }

        try {
            contracts[2]=createContract(dateFormat.parse("00/00/2016"),"3 YEARS",5500.0);
        } catch (ParseException e) {   e.printStackTrace();  }

        try {
            contracts[3]=createContract(dateFormat.parse("00/00/2016"),"1 YEARS",6600.0);
        } catch (ParseException e) {   e.printStackTrace();  }


        /*---------------------matches input--------------------- */
        try {
            matches[0]=createMatch(dateFormat.parse("00/00/2016"),dateFormat.parse("09/09/2017"));
        } catch (ParseException e) {   e.printStackTrace();  }

        try {
            matches[1]=createMatch(dateFormat.parse("00/00/2015"),dateFormat.parse("09/09/2016"));
        } catch (ParseException e) {   e.printStackTrace();  }

        try {
            matches[2]=createMatch(dateFormat.parse("00/00/2015"),dateFormat.parse("09/09/2018"));
        } catch (ParseException e) {   e.printStackTrace();  }

        try {
            matches[3]=createMatch(dateFormat.parse("00/00/2016"),dateFormat.parse("09/09/2017"));
         } catch (ParseException e) {   e.printStackTrace();  }


        /*---------------------matchEvents input--------------------- */
        try {
            matchEvents[0]=createMatchEvent("1 ",dateFormat.parse("09/09/2017"));

        } catch (ParseException e) {   e.printStackTrace();  }

        try {
            matchEvents[1]=createMatchEvent(" 2",dateFormat.parse("09/09/2018"));

        } catch (ParseException e) {   e.printStackTrace();  }

        try {
            matchEvents[2]=createMatchEvent("3 ",dateFormat.parse("09/09/2016"));

        } catch (ParseException e) {   e.printStackTrace();  }

        try {
            matchEvents[3]=createMatchEvent(" 4",dateFormat.parse("09/09/2015"));

        } catch (ParseException e) {   e.printStackTrace();  }

        /*---------------------MatchEventHasUser input--------------------- */
        matchEventHasUsers[0]=createMatchEventHasUser();
        matchEventHasUsers[1]=createMatchEventHasUser();
        matchEventHasUsers[2]=createMatchEventHasUser();
        matchEventHasUsers[3]=createMatchEventHasUser();
        /*---------------------Staduim input--------------------- */
        staduims[0]=createStaduim("azadi");
        staduims[1]=createStaduim("samen");
        staduims[2]=createStaduim("takti");
        staduims[3]=createStaduim("zobahan");
        /*---------------------Team input--------------------- */
        teams[0]=createTeam("perspolis","1",0);
        teams[1]=createTeam("esteglal","2",1);
        teams[2]=createTeam("zobahan","3",2);
        teams[3]=createTeam("pars","4",3);
        /*---------------------User input--------------------- */
        //-----------------------coach
        inputUserFirstPart=new InputUserFirstPart("ali","ahadi");
        try {
        inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/1990"),"coach");
        } catch (ParseException e) {   e.printStackTrace();  }
        users[0]=createUser();

        inputUserFirstPart=new InputUserFirstPart("mohsen","jamali");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/1990"),"coach");
        } catch (ParseException e) {   e.printStackTrace();  }
        users[1]=createUser();

        inputUserFirstPart=new InputUserFirstPart("rasol","masomi");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/1980"),"coach");
        } catch (ParseException e) {   e.printStackTrace();  }
        users[2]=createUser();

        inputUserFirstPart=new InputUserFirstPart("javad","daneshi");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/1970"),"coach");
        } catch (ParseException e) {   e.printStackTrace();  }
        users[3]=createUser();

        //-----------------------player
        inputUserFirstPart=new InputUserFirstPart("ali","ahadi");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/2000"),"player");
        } catch (ParseException e) {   e.printStackTrace();  }
        users[4]=createUser();

        inputUserFirstPart=new InputUserFirstPart("massod","ozil");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/2000"),"player");

        } catch (ParseException e) {   e.printStackTrace();  }
        users[5]=createUser();

        inputUserFirstPart=new InputUserFirstPart("lionel","mesi");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/2000"),"player");

        } catch (ParseException e) {   e.printStackTrace();  }
        users[6]=createUser();

        inputUserFirstPart=new InputUserFirstPart("ali","karimi");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/2000"),"player");

        } catch (ParseException e) {   e.printStackTrace();  }
        users[7]=createUser();

        inputUserFirstPart=new InputUserFirstPart("mehdi","taremi");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/2000"),"player");
        } catch (ParseException e) {   e.printStackTrace();  }
        users[8]=createUser();

        inputUserFirstPart=new InputUserFirstPart("majid","farhadi");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/2000"),"player");
        } catch (ParseException e) {   e.printStackTrace();  }
        users[9]=createUser();

        inputUserFirstPart=new InputUserFirstPart("samad","marfavi");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/2000"),"player");
        } catch (ParseException e) {   e.printStackTrace();  }
        users[10]=createUser();

        inputUserFirstPart=new InputUserFirstPart("ali","sabori");
        try {
            inputUserSecondPart=new InputUserSecondPart(dateFormat.parse("09/09/2000"),"player");
        } catch (ParseException e) {   e.printStackTrace();  }
        users[11]=createUser();

        /*-----------------------------input data about relation---------------------------------- */
        //--------------------------------city
        Set<Team> teamSet1= new HashSet<>();
        teamSet1.add(teams[0]);
        Set<Staduim> staduim1= new HashSet<>();
        staduim1.add(staduims[0]);

        cities[0].setStaduim(staduim1);
        cities[0].setTeamSet(teamSet1);

        Set<Team> teamSet2= new HashSet<>();
        teamSet2.add(teams[1]);
        Set<Staduim> staduim2= new HashSet<>();
        staduim2.add(staduims[1]);

        cities[1].setStaduim(staduim2);
        cities[1].setTeamSet(teamSet2);

        Set<Team> teamSet3= new HashSet<>();
        teamSet3.add(teams[2]);
        Set<Staduim> staduim3= new HashSet<>();
        staduim3.add(staduims[2]);

        cities[2].setStaduim(staduim3);
        cities[2].setTeamSet(teamSet3);

        Set<Team> teamSet4= new HashSet<>();
        teamSet4.add(teams[3]);
        Set<Staduim> staduim4= new HashSet<>();
        staduim4.add(staduims[3]);

        cities[3].setStaduim(staduim4);
        cities[3].setTeamSet(teamSet4);

        cityDao.save(cities[0]);
        cityDao.save(cities[1]);
        cityDao.save(cities[2]);
        cityDao.save(cities[3]);
        //--------------------------------contracts
        contracts[0].setTeam(teams[0]);
        contracts[0].setUser(users[0]);

        contracts[1].setTeam(teams[1]);
        contracts[1].setUser(users[1]);

        contracts[2].setTeam(teams[2]);
        contracts[2].setUser(users[2]);

        contracts[3].setTeam(teams[3]);
        contracts[3].setUser(users[3]);

        contractDao.save( contracts[0]);
        contractDao.save( contracts[1]);
        contractDao.save( contracts[2]);
        contractDao.save( contracts[3]);

        //--------------------------------matches
        matches[0].setAwayTeam(teams[3]);
        matches[0].setHomeTeam(teams[0]);
        matches[0].setStaduim(staduims[0]);

        matches[1].setAwayTeam(teams[1]);
        matches[1].setHomeTeam(teams[0]);
        matches[1].setStaduim(staduims[1]);

        matches[2].setAwayTeam(teams[2]);
        matches[2].setHomeTeam(teams[1]);
        matches[2].setStaduim(staduims[2]);

        matches[3].setAwayTeam(teams[3]);
        matches[3].setHomeTeam(teams[2]);
        matches[3].setStaduim(staduims[0]);

        matchDeatailDao.save(matches[0]);
        matchDeatailDao.save(matches[1]);
        matchDeatailDao.save(matches[2]);
        matchDeatailDao.save(matches[3]);

        //--------------------------------MatchEvent

        matchEvents[0].setMatchId(matches[0]);
        matchEvents[1].setMatchId(matches[1]);
        matchEvents[2].setMatchId(matches[2]);
        matchEvents[3].setMatchId(matches[3]);

        matchEventDao.save( matchEvents[0]);
        matchEventDao.save( matchEvents[1]);
        matchEventDao.save( matchEvents[2]);
        matchEventDao.save( matchEvents[3]);
        //--------------------------------Staduim

        staduims[0].setCity(cities[0]);
        staduims[1].setCity(cities[1]);
        staduims[2].setCity(cities[2]);
        staduims[3].setCity(cities[3]);

        staduimDao.save(staduims[0]);
        staduimDao.save(staduims[1]);
        staduimDao.save(staduims[2]);
        staduimDao.save(staduims[3]);

        //--------------------------------team

        teams[0].setCity(cities[0]);
        teams[1].setCity(cities[0]);
        teams[2].setCity(cities[0]);
        teams[3].setCity(cities[0]);

        teamDao.save(teams[0]);
        teamDao.save(teams[1]);
        teamDao.save(teams[2]);
        teamDao.save(teams[3]);
        //--------------------------------MatchEventHasUser

        Set<User> users1= new HashSet<>();
        users1.add(users[5]);
        users1.add(users[6]);

        matchEventHasUsers[0].setMatchEvent(matchEvents[0]);
        matchEventHasUsers[0].setUsers(users1);


        Set<User> users2= new HashSet<>();
        users2.add(users[7]);
        users2.add(users[6]);

        matchEventHasUsers[1].setMatchEvent( matchEvents[3]);
        matchEventHasUsers[1].setUsers(users2);


        Set<User> users3= new HashSet<>();
        users3.add(users[8]);
        users3.add(users[6]);

        matchEventHasUsers[2].setMatchEvent( matchEvents[1]);
        matchEventHasUsers[2].setUsers(users3);


        Set<User> users4= new HashSet<>();
        users4.add(users[9]);
        users4.add(users[10]);

        matchEventHasUsers[3].setMatchEvent( matchEvents[2]);
        matchEventHasUsers[3].setUsers(users4);

        matchEventHasUserDao.save(matchEventHasUsers[0]);
        matchEventHasUserDao.save(matchEventHasUsers[1]);
        matchEventHasUserDao.save(matchEventHasUsers[2]);
        matchEventHasUserDao.save(matchEventHasUsers[3]);




        //--------------------------------user

        /////////////////////////////////////


        }
    /////////////////////////////////////////////////////////

    public static City createCity(String name)
    {
        City city = new City();
        city.setName(name);
        return city;
    }

    public static Contract createContract(   Date year, String type,Double salary)
    {
        Contract contract = new Contract();
        contract.setSalary(salary);
        contract.setType(type);
        contract.setYear(year);
        return contract;
    }

    public static MatchDeatail createMatch( Date year, Date date)
    {
        MatchDeatail match = new MatchDeatail();
        match.setYear(year);
        match.setDate(date);
        return match;
    }

    public static MatchEvent createMatchEvent(String type, Date date)
    {
        MatchEvent matchEvent = new MatchEvent();
        matchEvent.setType(type);
        matchEvent.setDate(date);
        return matchEvent;
    }

    public static MatchEventHasUser createMatchEventHasUser(int userId )
    {
        MatchEventHasUser matchEventHasUser = new MatchEventHasUser();

        return matchEventHasUser;
    }
    public static Staduim createStaduim(  String name )
    {
        Staduim staduim = new Staduim();
        staduim.setName(name);

        return staduim;
    }
    public static Team createTeam( String name, String code, int coachId)
    {
        Team team = new Team();
        team.setName(name);
        team.setCode(code);
        team.setCoachId(coachId);
        return team;
    }
    public static User createUser()
    {
        User user = new User();
        user.setFirstName(inputUserFirstPart.getFirstName());
        user.setLastName(inputUserFirstPart.getLastName());
        user.setUserType(inputUserSecondPart.getUserType());
        user.setBirthday(inputUserSecondPart.getBirthday());

        return user;
    }
    public static MatchEventHasUser createMatchEventHasUser()
    {
        MatchEventHasUser matchEventHasUser = new MatchEventHasUser();
        return matchEventHasUser;
    }


    //////////////////////////////////////////////////////////

    public static void initializeDao(EntityManager entityManager) {
           cityDao= new CityDao(entityManager);;
           contractDao= new ContractDao(entityManager);;
           matchDeatailDao= new MatchDeatailDao(entityManager);;
           matchEventDao= new MatchEventDao(entityManager);;
           matchEventHasUserDao= new MatchEventHasUserDao(entityManager);;
           staduimDao= new StaduimDao(entityManager);;
           teamDao= new TeamDao(entityManager);;
           userDao= new UserDao(entityManager);;

    }

    public static void deleteData() {
        City newCity = cityDao.load(3);
        try {
            cityDao.delete(newCity);
        } catch (Exception e) {
        }

    }

    public static void updateData() {
         Team newTeam = teamDao.load(2);
        City newCity = cityDao.load(1);


        newTeam.setCity(newCity);
        teamDao.update(newTeam);
    }

    public static <T> void showData() {
        User newUser1 = userDao.load(2);
        User newUser2 = userDao.load(3);

        MatchEventHasUser newMatchEventHasUser = matchEventHasUserDao.load(1);


        System.out.println("************************************\n");
        System.out.println(" Id= " + newUser1.getId() + "  Number= " + newUser1.getFirstName() + "  City= " + newUser1.getLastName());

        System.out.println("************************************\n");
        System.out.println(" Id= " + newUser2.getId() + "  Number= " + newUser2.getFirstName() + "  City= " + newUser2.getLastName());
        System.out.println("************************************\n");



        System.out.println("****************** newMatchEventHasUser******************\n");
        System.out.println(" Id= " + newMatchEventHasUser.getId()   );
        System.out.println("************************************\n");
        System.out.println(" MatchEvent= " + newMatchEventHasUser.getMatchEvent() .getId() +" MatchId= " + newMatchEventHasUser.getMatchEvent() .getMatchId() .getId() );
        System.out.println("************************************\n");




        boolean flage2=false;
        for(User object:newMatchEventHasUser.getUsers())
        {
            if(flage2==false) {
                flage2=true;
                System.out.println("---------------information from students have relation by player----------------\n");
            }
            System.out.println("        FirstName:  "+object.getFirstName()+  "   LastName:   " + object.getLastName() );
            System.out.println("          _______________________________\n"  );
        }








    }


}
