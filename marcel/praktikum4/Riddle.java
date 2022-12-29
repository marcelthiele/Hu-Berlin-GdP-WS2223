package marcel.praktikum4;

public class Riddle {

    public static int numOfSolutions = 0;

    public static void main(String[] args) {
        if (args.length == 0)
            System.out.println("Bitte einen Parameter eingeben");

        int n = Integer.parseInt(args[0]);
        if (n < 1)
            System.out.println("Bitte eine Zahl größer 0 eingeben");
        if (n > 15)
            System.out.println("Bitte eine Zahl kleiner als 15 eingeben");

        riddle(n, new int[2 * n]);
        if(numOfSolutions > 0)
            System.out.println(numOfSolutions/2 + " Loesungen");
            else
            System.out.println("keine Loesung");
    }

    public static boolean riddle(int currentN, int[] prevArray) {
        if (currentN < 1) {
            // Print array, hat geklappt
            String printString = "";
            for (int i = 0; i < prevArray.length; i++) {
                printString += prevArray[i];
            }
            System.out.println(printString);

            numOfSolutions++; //TODO das hier in der Rekursion speichern, nicht extern

            return true;
        }

        for (int i = 0; i < prevArray.length - currentN - 1; i++) {
            int[] currentArray = copy(prevArray);
            if (currentArray[i] == 0 && currentArray[i + currentN + 1] == 0) {
                currentArray[i] = currentN;
                currentArray[i + currentN + 1] = currentN;

                riddle(currentN - 1, currentArray);
                // if(riddle(currentN - 1, currentArray))
                    // return true;
            }
        }

        return false;
    }

    public static int[] copy(int[] prevArray) {
        int[] retArray = new int[prevArray.length];

        for (int i = 0; i < retArray.length; i++) {
            retArray[i] = prevArray[i];
        }

        return retArray;
    }

}