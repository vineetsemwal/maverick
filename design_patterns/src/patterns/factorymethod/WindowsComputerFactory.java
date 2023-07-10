package patterns.factorymethod;

public class WindowsComputerFactory implements IComputerFactory{
    @Override
    public WindowsComputer newComputer() {
        WindowsComputer computer=new WindowsComputer("intel i5","windows");
        return computer;
    }
}
