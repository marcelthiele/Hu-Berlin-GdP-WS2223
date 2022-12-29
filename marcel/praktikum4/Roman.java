package marcel.praktikum4;

public class Roman {

    //TODO Error handling wenn eingabe größer als 5000, kleiner 1, keine eingabe

    public static void main(String[] args) {
        for(int i = 1; i <= 5000; i++){
            System.out.println(i + ": " + roman(i));
        }
    }

    public static String roman(int n) {
        if (n < 1)
            return "";

        int[] integerValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 5, 4, 1 };
        String[] romanValues = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "V", "IV", "I" };

        String retString = "";

        for (int i = 0; i < integerValues.length; i++) {
            if (n >= integerValues[i])
                return retString += romanValues[i] + roman(n - integerValues[i]);
        }

        return ""; // ERROR - should not be reached
    }

}
