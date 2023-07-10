package patterns.factorymethod;

public class MacFactory implements IComputerFactory{
    @Override
    public Computer newComputer() {
        MacComputer mac=new MacComputer("M2","macos");
        return mac;
    }
}
