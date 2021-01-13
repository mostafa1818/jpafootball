package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
public class MatchEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String type;

    @Column
    private Date date;

//    @OneToOne(cascade = CascadeType.ALL)
//    private MatchDeatail matchId;

    @ManyToOne(targetEntity = MatchDeatail.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_matchId", referencedColumnName = "id")
    private MatchDeatail matchId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MatchDeatail getMatchId() {
        return matchId;
    }

    public void setMatchId(MatchDeatail matchId) {
        this.matchId = matchId;
    }
}
