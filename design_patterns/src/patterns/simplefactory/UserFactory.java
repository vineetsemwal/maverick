package patterns.simplefactory;

public class UserFactory {

    public static User newUser(UserType userType){
        if(userType==UserType.REGULAR){
            return new RegularUser();
        }
        if(userType==UserType.BUSINESS_USER){
            return new BusinessUser();
        }
        if (userType==UserType.EMPLOYEE){
            return new Employee();
        }
        throw new UnsupportedOperationException("usertype not expected");
    }

}
