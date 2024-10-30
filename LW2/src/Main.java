import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        char action = scanner.next().charAt(0);
        Calculator calculator;

        calculator = (x,y) -> {
            float rez = 0;
            switch (action) {
                case '-':
                    rez = x-y;
                    break;

                case '+':
                    rez = x+y;
                    break;

                case '*':
                    rez = x*y;
                    break;

                case '/':
                    if (y > 0) {
                        rez = x/y;
                    }
            }
            return rez;
        };

        System.out.println(calculator.calculate(a,b));
    }
}