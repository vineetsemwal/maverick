package patterns.facade;

import java.util.*;

public class CustomerServiceImpl implements ICustomerService{
    private Map<Long,Customer>store=new HashMap<>();

    private Set<Long> signedInUsersId =new HashSet<>();

    @Override
    public void register(Customer customer) {
        store.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(long customerId) {
        return store.get(customerId);
    }

    @Override
    public List<Customer> fetchAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Customer signIn(long signInUserId) {
         signedInUsersId.add(signInUserId);
         return store.get(signInUserId);
    }

    @Override
    public boolean isSignedIn(long signIn) {
        return signedInUsersId.contains(signIn);
    }
}
