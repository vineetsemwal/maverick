package patterns.singleton;

public class ApplicationMain {
    public static void main(String[] args) {
        Application app1=Application.getInstance();
        Application app2=Application.getInstance();
        boolean same=app1==app2;
        System.out.println("instancencs same="+same);
        int serverPort=app1.getServerPort();
        String driverClass=app1.getDriverClass();
        System.out.println("server port="+serverPort+",driver="+driverClass);
        System.out.println("appe="+app1);
    }
}
