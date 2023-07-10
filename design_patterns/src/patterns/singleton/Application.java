package patterns.singleton;

public class Application {
    private static Application instance;
    private int serverPort=8085;
    private String driverClass="com.mysql.jdbc.MysqlDriver";
    private RunMode runMode=RunMode.Development;

    private Application(){}

    public static Application getInstance(){
        if(instance!=null){
            return instance;
        }
        instance=new Application();
        return instance;
    }

    public static enum RunMode{
        Development,
        Production
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public RunMode getRunMode() {
        return runMode;
    }

    @Override
    public String toString() {
        return "Application{" +
                "serverPort=" + serverPort +
                ", driverClass='" + driverClass + '\'' +
                ", runMode=" + runMode +
                '}';
    }
}
