package marcel.praktikum2;

public class Nolindrom {

    public static void main(String[] args) {
        int N = 1345678;// Integer.parseInt(args[0]);
        int R = 0;
        int steps = 0;

        while (steps <= 100) {
            R = getReverse(N);
            if (isPalindrom((N + R)))
                break;
            N = N + R;
            steps++;
        }

        System.out.println("N = " + N + ", R = " + R + ", Summe= " + (N + R));
    }

    /**
     * 
     * @param i
     * @return returns whether i is a Palindrom (1001, 2002, 3113,...)
     */
    private static boolean isPalindrom(int i) {
        return getReverse(i) == i;
    }

    /**
     * 
     * @param n
     * @return reversed number from n (eg. 123 -> 321)
     */
    private static int getReverse(int n) {
        int reverse = 0;

        while (n > 0) {
            int temp = n % 10;
            reverse = 10 * reverse + temp;
            n /= 10;
        }

        return reverse;
    }

}