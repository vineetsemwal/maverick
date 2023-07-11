package patterns.facade;

public interface IFacadeService {
    void register(Customer customer);

    Customer findCustomerById(long customerId);

    Product findProductById(long productId);

    boolean isSignedIn(long signIn);


}
