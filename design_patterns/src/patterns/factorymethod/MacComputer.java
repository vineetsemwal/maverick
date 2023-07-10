package patterns.factorymethod;

public class MacComputer extends AbstractComputer{

    public MacComputer(String processor, String os){
        super(processor,os);
    }

    @Override
    public void boots() {
        System.out.println("Mac boots");
    }

    @Override
    public void shutdown() {
        System.out.println("Mac shutdown");
    }

    @Override
    public void works() {
        System.out.println("MAc is working");
    }
}
