OldClient is using IOldService which is provided by our Application

NewClient wants to use INewService which is currently not supported by our Application

Use adapter pattern so that NewClient is also supported

Use Map<Long, Product> in Old service implementation

Product{
long id

String name

double price

}

ProductDetails{

String name

double price


}

IOldService{

Product getProductById(productId)

}

INewService{

ProductDetails findProductById(productId)

}





