package marcel.praktikum4;

public class Roman {

    public static void main(String[] args) {
        if(args.length == 0) return;
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Bitte eine Zahl aus lateinischen Ziffern eigeben");
        }

        if(n < 1 || n > 5000){
            System.out.println("Bitte eine Zahl zwischen 1 und 5000 eingeben");
        }

        System.out.println(roman(n));

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
