package Input;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
@Data
public class InputUserSecondPart {


    private Date birthday  ;

    private String    userType;

    public InputUserSecondPart(   Date birthday   ,String    userType)
    {

        this.birthday=birthday;
        this.userType=userType;



    }
}
