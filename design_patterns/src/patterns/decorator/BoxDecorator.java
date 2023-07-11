package patterns.decorator;

public class BoxDecorator extends ComponentDecorator{
    public BoxDecorator(IComponent component) {
        super(component);
    }

    @Override
    public void renders() {
        System.out.println("box boundaries starts");
        super.renders();
        System.out.println("box boundaries stops");
    }
}