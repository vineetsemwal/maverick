package patterns.facade;

import java.util.List;

public interface ICustomerService {
    void register(Customer customer);

    Customer findById(long customerId);

    List<Customer>fetchAll();

    Customer signIn(long signIn);

    boolean isSignedIn(long signIn);

}
