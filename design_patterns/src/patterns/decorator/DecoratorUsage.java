package patterns.decorator;

public class DecoratorUsage {
    public static void main(String[] args) {
        IComponent original=new OriginalComponent();
        IComponent box=new BoxDecorator(original);
        //box.renders();
/*
        IComponent circleOutsideOriginal=new CircleDecorator(original);
        //circleOutsideOriginal.renders();
*/

        IComponent circleOutsideBox=new CircleDecorator(box);
        circleOutsideBox.renders();

    }
}
