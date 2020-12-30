package Input;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
@Data
public class InputUserFirstPart {

    private String    firstName;

    private String    lastName;




    public InputUserFirstPart(  String    firstName, String    lastName)
    {

        this.firstName=firstName;
        this.lastName=lastName;


    }
}
