package patterns.proxy;

public class FileComponentProxy implements IComponent{
    private String data;
    private FileComponent originalComponent;
    private String fileName;
    public FileComponentProxy(String fileName){
        this.fileName=fileName;
    }

    @Override
    public String load() {
        if(originalComponent !=null){
            return data;
        }
        originalComponent=new FileComponent(fileName);
        data= originalComponent.load();
        return data;
    }

    @Override
    public void display() {
        String data=load();
        System.out.println("displaying"+data +"content from file="+fileName);
    }
}
