package patterns.adapter;

public class NewClient {
    private IExpected expected;
    public NewClient(IExpected expected){
        this.expected=expected;
    }
    public void printDetails(){
        PersonDTO desired=expected.fetchPerson();
        System.out.println("new client printing "+desired);
    }
}
