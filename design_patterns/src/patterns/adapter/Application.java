package patterns.adapter;

public class Application implements IExisting{
    @Override
    public Person getPerson() {
        Person person=new Person(1,"Madan","channai","Resident A1");
        return person;
    }
}
