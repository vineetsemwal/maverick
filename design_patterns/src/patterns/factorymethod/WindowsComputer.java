package patterns.factorymethod;

public class WindowsComputer extends AbstractComputer{

    public WindowsComputer(String processor, String os){
        super(processor,os);
    }

    @Override
    public void boots() {
        System.out.println("Windows boots");
    }

    @Override
    public void shutdown() {
        System.out.println("Windows shutdown");
    }

    @Override
    public void works() {
        System.out.println("Windows works");
    }
}
