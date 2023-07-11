package patterns.adapter;

public class AdapterUsage {
    public static void main(String[] args) {
        IExisting existing=new Application();
        OldClient oldClient=new OldClient(existing);
        oldClient.printDetails();

        Adapter adapter=new Adapter(existing);
        NewClient newClient=new NewClient(adapter);
        newClient.printDetails();


    }
}
