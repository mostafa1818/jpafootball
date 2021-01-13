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
    private Integer id;

    @Column
    private Date year;

    @Column
    private Date date;

    @Column
    private Integer season;



    @ManyToOne(targetEntity = Team.class ,cascade = CascadeType.ALL)
    private Team homeTeam;

    @ManyToOne(targetEntity = Team.class,cascade =CascadeType.ALL)
    private Team awayTeam;


    @ManyToOne(targetEntity = Staduim.class ,cascade =CascadeType.ALL)
    private  Staduim staduim;

    @ManyToOne(targetEntity = Score.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_score", referencedColumnName = "id")
    private  Score score;



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
