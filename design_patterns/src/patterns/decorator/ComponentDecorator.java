package patterns.decorator;

public abstract class ComponentDecorator implements IComponent {
    private IComponent originalComponent;

    public ComponentDecorator(IComponent component) {
        this.originalComponent = component;
    }

    public IComponent getOriginalComponent(){
        return originalComponent;
    }

    @Override
    public void renders() {
        originalComponent.renders();
    }
}