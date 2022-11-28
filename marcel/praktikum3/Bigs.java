package marcel.praktikum3;

public class Bigs {
    /**
     * Addiert die Ziffernfelder a und b
     * 
     * @param a
     * @param b
     * @return
     */
    public static int[] add(int[] a, int[] b) {
        // FIXME Works!
        int biggerArrayLength = a.length > b.length ? a.length : b.length;
        System.out.println("Bigger array Length: " + biggerArrayLength);

        int[] retArray = new int[biggerArrayLength + 1]; // Eine Stelle mehr, falls die beiden vorletzten Ziffern aus a
                                                         // und b mehr als 10 ergeben

        int imSinn = 0;
        for (int i = 0; i < biggerArrayLength; i++) {
            int currentSum = a[i] + b[i] + imSinn;
            imSinn = currentSum / 10;
            currentSum = currentSum % 10;
            retArray[i] = currentSum;

        }
        if (imSinn > 0)
            retArray[retArray.length - 1] = imSinn;

        //TODO das könnte man auch anders machen: wenn imSinn == 0 ist, sind wir sicher, dass die letzte Stelle von retArray entfernt werden muss. Somit ist der Check mit ok und so weiter gar nicht notwendig i Think

        if (!ok(retArray)) {
            if (retArray[retArray.length - 1] == 0) {
                // Remove "leading Zero"
                int[] trueRetArray = new int[retArray.length - 1];

                for (int i = 0; i < retArray.length - 1; i++) {
                    trueRetArray[i] = retArray[i];
                }
            }
        }

        print(a);
        System.out.print(" + ");
        print(b);
        System.out.print(" = ");
        print(retArray);

        return retArray;
    }

    /**
     * Gibt das Ziffernfeld n in lesbarer dezimaler Form aus. Bei sehr langen Zahlen
     * soll das Format verwendet werden, welches am Ende auch von bc benutzt wird:
     * Umbruch nach 68 Ziffern mit einem \ am Ende
     * 
     * @param n
     */
    static void print(int[] n) {
        String printString = "";

        for(int i = n.length-1; i >= 0; i--){
            printString += n[i];
        }

        //TODO lange zahlen. siehe oben

        System.out.print(printString);
    }

    /**
     * konstruiert ein einstelliges Ziffernfeld aus der Ziffer d
     * 
     * @param d
     * @return
     */
    static int[] digit(int d) {
        return null;
    }

    /**
     * konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
     * 
     * @return
     */
    static int[] Null() {
        return null;
    }

    /**
     * konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
     * 
     * @return
     */
    static int[] One() {
        return null;
    }

    /**
     * Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
     * 
     * @param n
     * @return
     */
    static int mod10(int[] n) {
        return 0;
    }

    /**
     * ganzzahliger Quotient bei Division durch 10
     * 
     * @param n
     * @return
     */
    static int[] div10(int[] n) {
        return n;
    }

    /**
     * Umwandlung einer beliebigen int-Zahl in ein Ziffernfeld
     * 
     * @param n
     * @return
     */
    static int[] fromInt(int n) {
        return null;
    }

    /**
     * Kopiert den Wert von n
     * 
     * @param n
     * @return
     */
    static int[] copy(int[] n) {
        return n;
    }

    /**
     * Multipliziert das Ziffernfeld n mit einer (einstelligen!) int-Zahl
     * 
     * @param n
     * @param d
     * @return
     */
    static int[] times(int[] n, int d) {
        return n;
    }

    /**
     * Multipliziert das Ziffernfeld n mit 10
     * 
     * @param n
     * @return
     */
    static int[] times10(int[] n) {
        return n;
    }

    /**
     * multipliziert zwei Ziffernfelder
     * 
     * @param a
     * @param b
     * @return
     */
    static int[] times(int[] a, int[] b) {
        return b;
    }

    /**
     * Quadratzahl eines Ziffernfeldes
     * 
     * @param a
     * @return
     */
    static int[] square(int[] a) {
        return a;
    }

    /**
     * Kubikzahl eines Ziffernfeldes
     * 
     * @param a
     * @return
     */
    static int[] cubic(int[] a) {
        return a;
    }

    /**
     * Test auf kleiner-Relation zweier Ziffernfelder: a < b?
     * 
     * @param a
     * @param b
     * @return
     */
    static boolean less(int[] a, int[] b) {
        return false;
    }

    /**
     * Test auf Gleichheit zweier Ziffernfelder
     * 
     * @param a
     * @param b
     * @return
     */
    static boolean equal(int[] a, int[] b) {
        return false;
    }

    /**
     * Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
     * mindestens eine Ziffer, alle Positionen liegen zwischen 0 und 9.
     * Keine fuehrenden Nullen (ausser bei Null selbst)
     * 
     * @param n
     * @return
     */
    static boolean ok(int[] n) {
        if (n.length == 1 && n[0] == 0)
            return true; // Abbruchbedingung fuer Null selbst

        for (int i = 0; i < n.length; i++) {
            if (n[i] / 10 != 0)
                return false;
        }

        // Fuehrende Nullen und n selbst ist nicht Null
        if (n[n.length - 1] == 0)
            return false;

        // In allen anderen Fällen -> ok
        return true;
    }

    /**
     * Gibt die (kleinste) Ziffer mit der groessten Haeufigkeitn in n aus
     * 
     * @param n
     */
    static void maxDigit(int[] n) {
    }

    public static void main(String[] args) {

        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] added = add(a, b);
        System.out.println();
        System.out.println("Added:");
        print(added);


        // int[] a = One();

        // for (int i = 0; i < 33222; i++) {
        //     a = times(a, 2);
        // }

        // System.out.println("2^33222 hat " + a.length + " Stellen");
        // print(a);

        // System.out.println();

        // int[] b = fromInt(13);
        // int[] c = copy(b);

        // for (int i = 0; i < 8978; i++) {
        //     c = times(c, b);
        // }

        // System.out.println("13^8978 hat " + c.length + " Stellen");
        // print(c);
        // System.out.println();

        // System.out.println(less(a, c));

        // maxDigit(a);
        // maxDigit(c);
    }
}