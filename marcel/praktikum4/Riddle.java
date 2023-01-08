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
        if (numOfSolutions > 0)
            System.out.println(numOfSolutions + " Loesungen");
        else
            System.out.println("keine Loesung");
    }

    // TODO es werden auch doppelte lösungen geprintet
    // Idee: Da nach numOfSolutions/2 prints, die Lösungen reversed und wieder
    // angezeigt werden, muss man also irgendwie den Zeitpunkt feststellen, wo die
    // prevLösung.reverse() == aktuelleLösung ist und dann abbrechen

    public static boolean riddle(int currentN, int[] prevArray) {
        // printArray(prevArray);
        if (currentN < 1) {
            // Print array, hat geklappt
            // System.out.println(currentN);
            printArray(prevArray);

            numOfSolutions++; // TODO das hier in der Rekursion speichern, nicht extern

            return true;
        }

        int grenze = prevArray.length - currentN - 1;
        if (currentN == prevArray.length / 2)
            grenze = currentN/2;
            
        for (int i = 0; i < grenze; i++) {
            int[] currentArray = copy(prevArray);
            if (currentArray[i] == 0 && currentArray[i + currentN + 1] == 0) {
                currentArray[i] = currentN;
                currentArray[i + currentN + 1] = currentN;
                // printArray(currentArray);

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

    public static void printArray(int[] arrayToPrint) {
        String printString = "";
        for (int i = 0; i < arrayToPrint.length; i++) {
            printString += arrayToPrint[i];
        }
        System.out.println(printString);
    }

}
