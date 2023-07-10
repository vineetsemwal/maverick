package patterns.factorymethod;

public class FactoryMethodUsage {

    public static void main(String[] args) {
        IComputerFactory windowsFactory=new WindowsComputerFactory();
        Computer windowsComputer=windowsFactory.newComputer();
        windowsComputer.boots();
        windowsComputer.works();
        windowsComputer.shutdown();
        IComputerFactory macFactory=new MacFactory();
        Computer mac=macFactory.newComputer();
        mac.boots();
        mac.works();
        mac.shutdown();
    }
}
