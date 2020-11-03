package convertToArabic;

import enumeration.RomanEnum;

import static enumeration.RomanEnum.*;

public class ToArabic {
    public static int toArabic(String num) {

        switch (num) {
            case "I":
                return I.getNumVal();
            case "II":
                return II.getNumVal();
            case "III":
                return III.getNumVal();
            case "IV":
                return IV.getNumVal();
            case "V":
                return V.getNumVal();
            case "VI":
                return VI.getNumVal();
            case "VII":
                return VII.getNumVal();
            case "VIII":
                return VIII.getNumVal();
            case "IX":
                return IX.getNumVal();
            case "X":
                return X.getNumVal();
            default:
                return 0;
        }
    }
}
