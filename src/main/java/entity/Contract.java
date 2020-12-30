package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date year;

    @Column
    private String type;

    @Column
    private Double salary;

    @OneToOne(targetEntity = Team.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Team", referencedColumnName = "id")
    private Team team;
//    @OneToOne( cascade = CascadeType.ALL)
//    private Team team;

    @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_User", referencedColumnName = "id")
    private User user;
//    @OneToOne( cascade = CascadeType.ALL)
//    private User user;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
