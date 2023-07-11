package patterns.adapter;

public class OldClient {
    private IExisting existing;
    public OldClient(IExisting existing){
        this.existing=existing;
    }
    public void printDetails(){
        Person person=existing.getPerson();
        System.out.println("old client printing "+ person);
    }
}
