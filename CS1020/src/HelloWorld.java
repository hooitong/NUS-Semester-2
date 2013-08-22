/**
 * This class accepts 3 types of input and produce the appropriate output based on given operation.
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 21/8/13
 * @version 1.0
 */

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        // declare variables
        Scanner sc = new Scanner(System.in);
        int inputType = 0;

        // call method to read user's input type
        inputType = readInputType(sc);

        // call method to read & evaluate user's input based on his input type
        evaluateInput(sc, inputType);
    }

    /**
     * This method reads the input type and return it back to the caller.
     *
     * @param sc The scanner object
     * @return The integer value of the input type
     */
    private static int readInputType(Scanner sc) {
        int inputType = sc.nextInt();
        return inputType;
    }

    /**
     * This method reads the input type and return it back to the caller.
     *
     * @param sc        The scanner object
     * @param inputType The input type indicated by the user
     * @return The integer value of the input type
     */
    private static void evaluateInput(Scanner sc, int inputType) {
        // declare variables
        String operator = "";
        int firstBit = 0, secondBit = 0, result = 0;

        switch (inputType) { // based on user's input type
            case 1: // accept N number of operations
                int maxIteration = sc.nextInt();
                for (int iteration = 0; iteration < maxIteration; iteration++) {
                    operator = sc.next();
                    firstBit = sc.nextInt();
                    secondBit = sc.nextInt();
                    result = evaluateOperation(operator, firstBit, secondBit);
                    // output the result
                    System.out.println(result);
                }
                break;
            case 2: // accept infinite number of operations until 0 is given
                while (true) {
                    operator = sc.next();
                    if (operator.equals("0")) break; // 0 is given, exit
                    firstBit = sc.nextInt();
                    secondBit = sc.nextInt();
                    result = evaluateOperation(operator, firstBit, secondBit);
                    // output the result
                    System.out.println(result);
                }

                break;
            case 3: // accept infinite number of operations until end of file
                while (sc.hasNext()) {
                    operator = sc.next();
                    firstBit = sc.nextInt();
                    secondBit = sc.nextInt();
                    result = evaluateOperation(operator, firstBit, secondBit);
                    // output the result
                    System.out.println(result);
                }
                break;
            default:
                System.exit(0);
                break;
        }
    }

    /**
     * This method reads the input type and return it back to the caller.
     *
     * @param operator  The operator to be used for evaluation of the 2 bits
     * @param firstBit  The first bit indicated by the user
     * @param secondBit The second bit indicated by the user
     * @return The integer resultant value from the operation
     */
    private static int evaluateOperation(String operator, int firstBit, int secondBit) {
        if (operator.equals("AND")) {
            if (firstBit == secondBit) return firstBit == 0 ? 0 : 1; // based on AND logic table
            else return 0;
        } else if (operator.equals("OR")) {
            if (firstBit == secondBit) return firstBit == 0 ? 0 : 1; // based on OR logic table
            else return 1;
        } else return -1; // invalid / unsupported operator
    }
}