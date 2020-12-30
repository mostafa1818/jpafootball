package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class MatchDeatail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date year;

    @Column
    private Date date;



    @OneToOne(targetEntity = Team.class ,cascade = CascadeType.ALL)
    private Team homeTeam;

    @OneToOne(targetEntity = Team.class,cascade =CascadeType.ALL)
    private Team awayTeam;


    @ManyToOne(targetEntity = Staduim.class ,cascade =CascadeType.ALL)
    private  Staduim staduim;



//    @OneToOne(targetEntity = Team.class ,cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_homeTeam", referencedColumnName = "id")
//    private Team homeTeam;
//
//    @OneToOne(targetEntity = Team.class,cascade =CascadeType.ALL)
//    @JoinColumn(name = "fk_awayTeam", referencedColumnName = "id")
//    private int awayTeam;
//
//
//    @ManyToOne(targetEntity = Staduim.class ,cascade =CascadeType.ALL)
//    @JoinColumn(name = "fk_stadium", referencedColumnName = "id")
//    private  Staduim staduim;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Staduim getStaduim() {
        return staduim;
    }

    public void setStaduim(Staduim staduim) {
        this.staduim = staduim;
    }
}
