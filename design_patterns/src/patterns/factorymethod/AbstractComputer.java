package patterns.factorymethod;

public abstract class AbstractComputer implements Computer{
    private String operatingSystem;
    private String processor;

    public AbstractComputer(String processor, String os){
        this.processor=processor;
        this.operatingSystem=os;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
}
