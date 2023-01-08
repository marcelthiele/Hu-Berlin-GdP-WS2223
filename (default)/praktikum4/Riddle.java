public class Riddle {

    public static int numOfSolutions = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Bitte einen Parameter eingeben");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        if (n < 1) {
            System.out.println("Bitte eine Zahl größer 0 eingeben");
            System.exit(1);
        }
        if (n > 15) {
            System.out.println("Bitte eine Zahl kleiner als 15 eingeben");
            System.exit(1);
        }

        riddle(n, new int[2 * n]);

        if (numOfSolutions == 1)
            System.out.println("eine Loesung");
        else if (numOfSolutions > 0)
            System.out.println(numOfSolutions + " Loesungen");
        else
            System.out.println("keine Loesung");
    }

    public static void riddle(int currentN, int[] prevArray) {
        if (currentN < 1) {
            // Print array, hat geklappt
            if (prevArray.length / 2 < 10)
                printArray(prevArray);

            numOfSolutions++; // TODO das hier in der Rekursion speichern, nicht extern
        }

        int threshold = prevArray.length - currentN - 1;
        if (currentN == prevArray.length / 2)
            threshold = currentN / 2;

        for (int i = 0; i < threshold; i++) {
            int[] currentArray = copyArray(prevArray);
            if (currentArray[prevArray.length - 1 - i] == 0 && currentArray[prevArray.length - 1 - (i + currentN + 1)] == 0) {
                currentArray[prevArray.length - 1 - i] = currentN;
                currentArray[prevArray.length - 1 - (i + currentN + 1)] = currentN;

                riddle(currentN - 1, currentArray);
            }
        }
    }

    public static int[] copyArray(int[] prevArray) {
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
