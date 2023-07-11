package patterns.adapter;

public class Person {
    private long id;
    private String name;
    private String city;
    private String flatAddress;

    public Person(long id, String name, String city, String flatAddress) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.flatAddress = flatAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFlatAddress() {
        return flatAddress;
    }

    public void setFlatAddress(String flatAddress) {
        this.flatAddress = flatAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", flatAddress='" + flatAddress + '\'' +
                '}';
    }
}
