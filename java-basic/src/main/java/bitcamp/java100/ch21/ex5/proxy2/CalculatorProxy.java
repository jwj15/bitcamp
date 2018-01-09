package bitcamp.java100.ch21.ex5.proxy2;

public class CalculatorProxy implements Calculator {

    Calculator realWorker = new CalculatorImpl();
    
    public void setCalculator(Calculator realWorker) {
        this.realWorker = realWorker;
    }
    
    @Override
    public int plus(int a, int b) {
        return realWorker.plus(a, b);
    }

    @Override
    public int minus(int a, int b) {
        return realWorker.minus(a, b);
    }
    

}
