package patterns.adapter;

public class Adapter implements IExpected{
    private IExisting existing;
    public Adapter(IExisting existing){
        this.existing=existing;
    }

    @Override
    public PersonDTO fetchPerson() {
       Person person= existing.getPerson();
       PersonDTO desired=new PersonDTO(person.getId(), person.getName());
       return desired;
    }
}
