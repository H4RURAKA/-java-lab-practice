import java.util.Scanner;

class OutOfRangeException extends Exception {
    public OutOfRangeException(String message) {
        super(message);
    }
}

class AddZeroException extends Exception {
    public AddZeroException(String message) {
        super(message);
    }
}

class SubtractZeroException extends Exception {
    public SubtractZeroException(String message) {
        super(message);
    }
}

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        scanner.close();

        try {
            int result = calculate(expression);
            System.out.println(result);
        } catch (AddZeroException | SubtractZeroException e) {
            System.out.println(e.getClass().getSimpleName());
        } catch (OutOfRangeException e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }

    private static int calculate(String expression) throws OutOfRangeException, AddZeroException, SubtractZeroException {
        int index = expression.contains("+") ? expression.indexOf("+") : expression.indexOf("-");
        char operator = expression.charAt(index);
        int a = Integer.parseInt(expression.substring(0, index));
        int b = Integer.parseInt(expression.substring(index + 1));

        if (operator == '+') {
            if (a == 0 || b == 0) {
                throw new AddZeroException("Addition with 0 is not allowed");
            }
        } else {
            if (a == 0 || b == 0) {
                throw new SubtractZeroException("Subtraction with 0 is not allowed");
            }
        }

        if ((a < 0 || a > 1000) || (b < 0 || b > 1000)) {
            throw new OutOfRangeException("Out of range");
        }

        int result = operator == '+' ? a + b : a - b;

        if (result < 0 || result > 1000) {
            throw new OutOfRangeException("Out of range");
        }

        return result;
    }
}
