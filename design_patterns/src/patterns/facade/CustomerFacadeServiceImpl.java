package patterns.facade;

public class CustomerFacadeServiceImpl implements IFacadeService{
    private IProductService productService;
    private ICustomerService customerService;

    public CustomerFacadeServiceImpl(IProductService productService, ICustomerService customerService){
       this.productService=productService;
       this.customerService=customerService;
    }

    @Override
    public void register(Customer customer) {
        customerService.register(customer);
    }

    @Override
    public Customer findCustomerById(long customerId) {
        return customerService.findById(customerId);
    }

    @Override
    public boolean isSignedIn(long signIn) {
        return customerService.isSignedIn(signIn);
    }

    @Override
    public Product findProductById(long productId) {
        return productService.findById(productId);
    }
}
