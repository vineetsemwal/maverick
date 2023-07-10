package patterns.protype;

public class PrototypeUsage {
    public static void main(String[] args) throws CloneNotSupportedException {
        Product product=new Product(1,"galaxy","phone",20000);
        Product copy=product.clone();
        System.out.println("copy="+copy);
    }
}
