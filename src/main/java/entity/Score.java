package entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column
    private Integer homeTeamScore;

    @Column
    private Integer awayTeamScore;

    @OneToOne(targetEntity = Team.class)
    private Team homeTeam;

    @OneToOne(targetEntity = Team.class)
    private Team awayTeam;






}
