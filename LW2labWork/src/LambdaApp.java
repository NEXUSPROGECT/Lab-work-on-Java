public class LambdaApp {
    static int x = 10;
    static int y = 20;
    public static void main(String[] args) {
        Operationable operation;
        operation = (x,y)->x+y;
        int result = operation.calculate(10, 20);
        System.out.println(result); //30
        Printable printer = s->System.out.println(s);
        printer.print("Hello Java!");
    }
}

