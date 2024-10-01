package basic.chap20;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class User {
    private String userId;
    private String userName;
    private String userPassword;
    private int userAge;
    private String userEmail;

}
