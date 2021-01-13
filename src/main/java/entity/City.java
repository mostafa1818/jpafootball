package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "city")
    private Set<Team> teamSet;

    @OneToMany(mappedBy = "city")
    private Set<Staduim> staduim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Team> getTeamSet() {
        return teamSet;
    }

    public void setTeamSet(Set<Team> teamSet) {
        this.teamSet = teamSet;
    }

    public Set<Staduim> getStaduim() {
        return staduim;
    }

    public void setStaduim(Set<Staduim> staduim) {
        this.staduim = staduim;
    }
}
