public class MethodOverloading {
    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();

        int sum1 = myCalculator.add(10, 20);
        System.out.println("Sum of two integers: " + sum1);

        int sum2 = myCalculator.add(10, 20, 30);
        System.out.println("Sum of three integers: " + sum2);

        double sum3 = myCalculator.add(4.5, 6.2);
        System.out.println("Sum of two doubles: " + sum3);
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

