package stepic.pinch.s35_7;

import java.util.function.DoubleUnaryOperator;


public class Main {

    public static void main(String[] args) {
        System.out.println(integrate(x->1, 0, 10));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double d = 1e-6;
        double sum = 0;
        double x = a;
        while(x<b){
            sum += f.applyAsDouble(x+d/2)*d;
            x += d;
        }
        return sum;
    }
}
