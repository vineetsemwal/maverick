package patterns.facade;

public class FacadeUsage {
    public static void main(String[] args) {
        IProductService productService=new ProductServiceImpl();
        ICustomerService customerService=new CustomerServiceImpl();
        Product product=new Product(12,"galaxy","phonme",20000);
        productService.add(product);
        IFacadeService facadeService=new CustomerFacadeServiceImpl(productService,customerService);
        Customer customer=new Customer(1,"mohan",21);
        facadeService.register(customer);
        Customer foundCustomer=facadeService.findCustomerById(1);
        System.out.println("found customer="+customer);
        Product foundProduct=facadeService.findProductById(12);
        System.out.println("found product="+product);
    }
}
