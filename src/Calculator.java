import java.util.Scanner;

public class Calculator {
    private int num1, num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add() {
        return num1 + num2;
    }

    public int subtract() {
        return num1 - num2;
    }

    public int multiply() {
        return num1 * num2;
    }

    public double divide() throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return (double) num1 / num2;
    }

    public static int getInputNumber(Scanner input, String message) {
        System.out.print(message);
        return input.nextInt();
    }

    public static char getInputOperator(Scanner input, String message) {
        System.out.print(message);
        return input.next().charAt(0);
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int num1 = getInputNumber(input, "첫번째 숫자를 입력하세요: ");
        int num2 = getInputNumber(input, "두번째 숫자를 입력하세요: ");
        Calculator calc = new Calculator(num1, num2);
        char operator = getInputOperator(input, "연산자를 입력하세요 (+, -, *, / 중 하나): ");
        double result;
        try {
            switch (operator) {
                case '+':
                    result = calc.add();
                    break;
                case '-':
                    result = calc.subtract();
                    break;
                case '*':
                    result = calc.multiply();
                    break;
                case '/':
                    result = calc.divide();
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    return;
            }
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator(0, 0);
        calc.run();
    }
}