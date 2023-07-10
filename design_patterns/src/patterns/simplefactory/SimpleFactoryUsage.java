package patterns.simplefactory;

public class SimpleFactoryUsage {
    public static void main(String[] args) {
        User user=UserFactory.newUser(UserType.BUSINESS_USER);

    }
}
