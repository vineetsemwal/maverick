package patterns.decorator;

public class OriginalComponent implements IComponent{
    @Override
    public void renders() {
        System.out.println("component renders");
    }
}
