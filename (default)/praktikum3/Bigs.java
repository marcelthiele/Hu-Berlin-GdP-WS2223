public class Bigs {
    /**
     * Addiert die Ziffernfelder a und b
     * 
     * @param a
     * @param b
     * @return
     */
    public static int[] add(int[] a, int[] b) {
        int biggerArrayLength = a.length > b.length ? a.length : b.length;
        // System.out.println("Bigger array Length: " + biggerArrayLength);

        int[] retArray = new int[biggerArrayLength + 1]; // Eine Stelle mehr, falls die beiden vorletzten Ziffern aus a
                                                         // und b mehr als 10 ergeben

        int rollover = 0;
        for (int i = 0; i < biggerArrayLength; i++) {
            int currentA = 0;
            int currentB = 0;
            if (i < a.length)
                currentA = a[i];
            if (i < b.length)
                currentB = b[i];

            int currentSum = currentA + currentB + rollover;
            rollover = currentSum / 10;
            currentSum = currentSum % 10;
            retArray[i] = currentSum;

        }
        if (rollover > 0)
            retArray[retArray.length - 1] = rollover;

        if (rollover == 0) {
            // Remove "leading Zero"
            int[] trueRetArray = new int[retArray.length - 1];

            for (int i = 0; i < retArray.length - 1; i++) {
                trueRetArray[i] = retArray[i];
            }

            retArray = trueRetArray;
        }

        // DEBUG PURPOSES
        // print(a);
        // System.out.print(" + ");
        // print(b);
        // System.out.print(" = ");
        // print(retArray);

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

        for (int i = n.length - 1; i >= 0; i--) {
            printString += n[i];
            if((n.length-i) % 68 == 0)
                printString += "\\\n";
        }



        System.out.print(printString + "\n");
    }

    /**
     * konstruiert ein einstelliges Ziffernfeld aus der Ziffer d
     * 
     * @param d
     * @return
     */
    static int[] digit(int d) {
        int[] retInt = { d };

        return retInt;
    }

    /**
     * konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
     * 
     * @return
     */
    static int[] Null() {
        return digit(0);
    }

    /**
     * konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
     * 
     * @return
     */
    static int[] One() {
        return digit(1);
    }

    /**
     * Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
     * 
     * @param n
     * @return
     */
    static int mod10(int[] n) {
        return n[0];
    }

    /**
     * ganzzahliger Quotient bei Division durch 10
     * 
     * @param n
     * @return
     */
    static int[] div10(int[] n) {
        int[] retArray = new int[n.length - 1];
        for (int i = 0; i < retArray.length; i++) {
            retArray[i] = n[i + 1];
        }

        // print(n);
        // System.out.print("/10 = ");
        // print(retArray);

        return retArray;
    }

    /**
     * Umwandlung einer beliebigen int-Zahl in ein Ziffernfeld
     * 
     * @param n
     * @return
     */
    static int[] fromInt(int n) {
        int retArraySize = 0;
        int copyOfN = n;

        while(copyOfN > 0){
            copyOfN /= 10;
            retArraySize++;
        }

        int[] retArray = new int[retArraySize];

        for(int i = 0; i < retArraySize; i++){
            retArray[i] = n % 10;
            n /= 10;
        }

        return retArray;
    }

    /**
     * Kopiert den Wert von n
     * 
     * @param n
     * @return
     */
    static int[] copy(int[] n) {
        int[] retArray = new int[n.length];

        for (int i = 0; i < n.length; i++) {
            retArray[i] = n[i];
        }

        return retArray;
    }

    /**
     * Multipliziert das Ziffernfeld n mit einer (einstelligen!) int-Zahl
     * 
     * @param n
     * @param d
     * @return
     */
    static int[] times(int[] n, int d) {
        int[] retArray = new int[n.length + 1];

        int rollover = 0;

        for (int i = 0; i < n.length; i++) {
            retArray[i] = n[i] * d + rollover;

            rollover = retArray[i] / 10;
            retArray[i] %= 10;
        }

        retArray[retArray.length - 1] = rollover;

        if (retArray[retArray.length - 1] == 0) {
            int[] realRetArray = new int[n.length];
            for (int i = 0; i < retArray.length - 1; i++) {
                realRetArray[i] = retArray[i];
            }
            retArray = realRetArray;
        }

        return retArray;
    }

    /**
     * Multipliziert das Ziffernfeld n mit 10
     * 
     * @param n
     * @return
     */
    static int[] times10(int[] n) {
        int[] retInt = new int[n.length + 1];
        for (int i = 0; i < n.length; i++) {
            retInt[i + 1] = n[i];
        }

        return retInt;
    }

    /**
     * Multipliziert die Zahl mit einer Potenz von 10
     * 
     * @param n die zu multiplizierende Zahl
     * @param m der Exponent von 10, mit dem multipliziert werden soll
     * @return n*10^m
     */
    static int[] timesPower10(int[] n, int m) {
        int[] retInt = new int[n.length + m];
        for (int i = 0; i < n.length; i++) {
            retInt[i + m] = n[i];
        }
        return retInt;
    }

    /**
     * multipliziert zwei Ziffernfelder
     * 
     * @param a
     * @param b
     * @return
     */
    static int[] times(int[] a, int[] b) {

        int[] summe = Null();
        // for (int aIndex = 0; aIndex < a.length; aIndex++) {
        for (int bIndex = 0; bIndex < b.length; bIndex++) {

            int[] tempSumme = times(a, b[bIndex]);

            tempSumme = timesPower10(tempSumme, bIndex);

            summe = add(summe, tempSumme);
        }
        // }

        // print(a);
        // System.out.print(" * ");
        // print(b);
        // System.out.print(" = ");
        // print(summe);

        return summe;
    }

    /**
     * Quadratzahl eines Ziffernfeldes
     * 
     * @param a
     * @return
     */
    static int[] square(int[] a) {
        return times(a, a);
    }

    /**
     * Kubikzahl eines Ziffernfeldes
     * 
     * @param a
     * @return
     */
    static int[] cubic(int[] a) {
        return times(times(a, a), a);
    }

    /**
     * Test auf kleiner-Relation zweier Ziffernfelder: a < b?
     * 
     * @param a
     * @param b
     * @return
     */
    static boolean less(int[] a, int[] b) {
        if (!ok(a) || !ok(b)) {
            return false;
        }

        if (a.length != b.length) {
            return a.length < b.length;
        }

        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < b[i])
                return true;
        }

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
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;
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
     * Gibt die (kleinste) Ziffer mit der groessten Haeufigkeitn in n aus.
     * Achtung: Kein check auf ok() -> muss vorher selbst durchgeführt werden
     * 
     * @param n
     */
    static void maxDigit(int[] n) {
        int[] distribution = new int[10]; // Hier werden die absoluten Haeufigkeiten der ziffern drin gespeichert, Wie oft
                                        // ist 0, wie oft ist 1 usw...

        for (int i = 0; i < n.length; i++) {
            distribution[n[i]]++;
        }

        int currentMax = 0;
        for (int j = 0; j < distribution.length; j++) {
            if (distribution[j] > distribution[currentMax])
                currentMax = j;
        }
        // System.out.println("Haeufigste Ziffer ist: " + currentMax);
        System.out.println(currentMax);
    }

    public static void main(String[] args) {
        int[] a = One();

        for (int i = 0; i < 33222; i++) {
            a = times(a, 2);
        }

        System.out.println("2^33222 hat " + a.length + " Stellen");
        print(a);

        System.out.println();

        int[] b = fromInt(13);
        int[] c = copy(b);

        for (int i = 1; i < 8978; i++) {
            c = times(c, b);
        }

        System.out.println("13^8978 hat " + c.length + " Stellen");
        print(c);
        System.out.println();

        System.out.println(less(a, c));

        maxDigit(a);
        maxDigit(c);
    }
}
