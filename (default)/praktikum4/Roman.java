public class Roman {

    public static String roman(int n) {
        if (n < 1)
            return "";

        int[] integerValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanValues = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        String retString = "";

        for (int i = 0; i < integerValues.length; i++) {
            if (n >= integerValues[i])
                return retString += romanValues[i] + roman(n - integerValues[i]);
        }

        return ""; // ERROR - should not be reached
    }
    
    public static void main(String[] args) {
        if(args.length == 0){
             System.out.println("Bitte eine Zahl als Parameter angeben.");
            System.exit(-1);
        }
       
        int  N = Integer.parseInt(args[0]);

        if(N < 1 || N > 5000){
            System.out.println("Die Zahl muss zwischen 1 und 5000 liegen.");
            System.exit(-1);
        }
        assert(1<=N && N<=5000);
        System.out.println(roman(N));

    }

}
