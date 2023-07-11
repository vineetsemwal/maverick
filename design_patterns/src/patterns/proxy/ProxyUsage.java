package patterns.proxy;

public class ProxyUsage {
    public static void main(String[] args) {
        IComponent component=new FileComponentProxy("abc.txt");
        component.display();
        component.display();
        component.display();
    }
}
