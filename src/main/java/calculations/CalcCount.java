package calculations;

import Exceptions.MyException;
import convertToArabic.ToArabic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static calculations.Operations.operation;

public class CalcCount {

    private int a = 0, b = 0;

    Integer[] arabic = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    String[] roman = {"I","II", "III", "IV", "V", "VI","VII","VIII","IX","X"};
    String[] operationMath = {"+", "-", "*", "/"};

    public void ioBuf()  {

        try (BufferedReader read = new BufferedReader(new InputStreamReader(System.in))) {

            int present = 0, count = 0;
            String op = "";
            String input = read.readLine();

            String[] strings = input.split("\\W");
            String[] operator = input.split("\\w");
            op = operator[operator.length - 1];
            int index = input.indexOf(op);
            int middleIndex = input.lastIndexOf(op) + 1;
            int lastIndex = input.length();

            while (count != 1) {
                count ++;
                for (int i = 0; i < arabic.length; i++) {
                    if (input.substring(0,index).equals(arabic[i].toString())) {
                        for (int j = 0; j < arabic.length; j++) {
                            if (input.substring(middleIndex, lastIndex).equals(arabic[j].toString())) {
                                present = 1;
                            }
                        }
                    } else if (input.substring(0,index).equals(roman[i])) {
                        for (int j = 0; j < roman.length; j++) {
                            if (input.substring(middleIndex, lastIndex).equals(roman[j])) {
                                present = 2;
                            }
                        }
                    }
                }
            }

            for ( int i = 0 ; i < operationMath.length ; i++ ) {

                if (present == 1 && op.equals(operationMath[i])) {

                    a = Integer.parseInt(strings[0]);
                    b = Integer.parseInt(strings[1]);
                    System.out.println("Result = " + operation(a, b, op));
                    return;

                } else if (present == 2 && op.equals(operationMath[i])) {

                    a = ToArabic.toArabic(strings[0]);
                    b = ToArabic.toArabic(strings[1]);

                    for ( int x = 0; x < roman.length ; x++ ) {

                        if (operation(a, b, op) == x + 1) {

                            System.out.println("Result = " + roman[x]);
                            return;

                        } else if (operation(a, b, op) > roman.length) {

                            System.out.println("Result = " + operation(a, b, op));
                            return;
                        }
                    }

                } else {

                    throw new MyException();
                }
            }

        } catch (NumberFormatException | IOException | MyException e) {
            System.out.println("Error input try again");
        }
    }
}
