***Use Spring boot and SpringDataJpa***

**Use Aop for logging the input arguments, result on methods and exceptions**

***Add api endpoints, do validations**


Customer{
id:Long

name:String 

int age

Address address

}

Address{
Long id

String hoseAddress

String city

}

ICustomerRepository{

....

}

ICustomerService{

CustomerDetails add(AddCustomerRequestDto )

List<CustomerDetails>findAllCustomersWithName(String name)

List<CustomerDetails>findAllCustomerWithAgeGreaterthan(int age)

}

Features to be Supported

1) Add Customer

2) find All customers by name  requested

3) Find all customers with agre greater than asked


Do Input Validations, Exception Handling

Api Endpoints

1) Add Customer

2) find all customers by name

3) find all customers with age greater than asked

