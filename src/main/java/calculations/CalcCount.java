package calculations;

import Exceptions.MyException;
import convertToArabic.ToArabic;
import convertToArabic.ToRoman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static calculations.Operations.operation;

public class CalcCount {

    private int a = 0, b = 0;
    boolean coincidence = false;

    Integer[] arabic = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    String[] roman = {"I","II", "III", "IV", "V", "VI","VII","VIII","IX","X"};
    String[] operationMath = {"+","-","*","/"};

    public void ioBuf()  {

        try (BufferedReader read = new BufferedReader(new InputStreamReader(System.in))) {

            int present = 0, count = 0;
            String x, z, y, str;
            str = read.readLine();
            String[] data = str.split(" ");

            x = data[0];
            z = data[1];
            y = data[2];

            int index = str.indexOf(z) - 1;
            int middleIndex = str.lastIndexOf(z) + 2;
            int lastIndex = str.length();

            while (count != 1) {
                count++;
                for (int i = 0; i < arabic.length; i++) {
                    if (str.substring(0, index).equals(arabic[i].toString())) {
                        for (int j = 0; j < arabic.length; j++) {
                            if (str.substring(middleIndex, lastIndex).equals(arabic[j].toString())) {
                                present = 1;
                            }
                        }
                    } else if (str.substring(0, index).equals(roman[i])) {
                        for (int j = 0; j < roman.length; j++) {
                            if (str.substring(middleIndex, lastIndex).equals(roman[j])) {
                                present = 2;
                            }
                        }
                    }
                }
            }
                for (int i = 0; i < operationMath.length; i++) {
                    if (z.equals(operationMath[i])) {
                        coincidence = true;
                    }
                }
                    if (present == 1 && coincidence == true) {

                        a = Integer.parseInt(x);
                        b = Integer.parseInt(y);
                        System.out.println("Result = " + operation(a, b, z));
                        return;

                    } else if (present == 2 && coincidence == true) {

                        a = ToArabic.decode(x);
                        b = ToArabic.decode(y);

                        System.out.println("Result = " + ToRoman.toRoman(operation(a, b, z)));
                        return;

                    } else {
                        throw new MyException();
                    }

        } catch (NumberFormatException | IOException | ArrayIndexOutOfBoundsException | MyException e) {
            System.out.println("Error input try again");
        }
    }
}
