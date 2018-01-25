package study.java8;

/**
 * Created by chunmei on 1/10/2018.
 */
interface InterfaceMethod {
    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}

class main{
    public void test()
    {
        InterfaceMethod formula = new InterfaceMethod() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        formula.calculate(100);     // 100.0
        formula.sqrt(16);           // 4.0

    }
}

