package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class MatchEventHasUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;



    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="FK_matchEvent")
    @OrderColumn(name="type")
    //  @JoinColumn(name = "fk_matchEvent", referencedColumnName = "id")

    private MatchEvent matchEvent;


    @OneToMany(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "fk_User", referencedColumnName = "id")
    @JoinColumn(name="FK_users")
    @OrderColumn(name="type1")
    private Set<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MatchEvent getMatchEvent() {
        return matchEvent;
    }

    public void setMatchEvent(MatchEvent matchEvent) {
        this.matchEvent = matchEvent;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
