package patterns.simplefactory;

public class CalculatorApp {
    public static void main(String[] args) {
        ICalculator calcy=new SamsungCalculator();
        int result=calcy.add(1,2);
        System.out.println("result="+result);
    }
}
