package calc;

import java.util.Scanner;
import java.util.logging.Logger;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Calculator.class.getName());


        logger.info("Enter first number: ");
        double firstNumber = scanner.nextDouble();

        logger.info("Enter second number: ");
        double secondNumber = scanner.nextDouble();

        logger.info("Choose operation: +, -, *, /");
        String operation = scanner.next();

        double result = calculate(firstNumber, secondNumber, operation);
        logger.info(()->"The result is: "+ result);

        scanner.close();
    }
    public static double calculate(double a, double b, String op) {
        switch (op) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                return 0.0;
        }
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
