package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int       id;

    @Column
    private String    firstName;

    @Column
    private String    lastName;

    @Column
    private String    userType;

    @Column
    private Date  birthday  ;







///////////////////////////////////////////////
//    @OneToMany(mappedBy = "student")
//    private Set<Address> addressSet;
//
//    @ManyToMany(cascade =  CascadeType.ALL)
//    @JoinTable(name = "Stu_Pro", joinColumns =@JoinColumn (name = "fk_Stu_ID"),
//            inverseJoinColumns =@JoinColumn(name = "FK_Tec_ID"))
//    private Set<Teacher> teacherSet;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
