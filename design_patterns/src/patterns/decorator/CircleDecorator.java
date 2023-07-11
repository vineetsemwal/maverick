package patterns.decorator;

public class CircleDecorator extends ComponentDecorator{
    public CircleDecorator(IComponent component) {
        super(component);
    }

    @Override
    public void renders() {
        System.out.println("circle starts");
        super.renders();
        System.out.println("circle finishes");

    }
}