package marcel.uebungsblatt3;

public class Sieb {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = M;


        int[] primes = findPrimes(M, N);

        for (int i = 0; i < primes.length; i++) {
            System.out.println(primes[i]);
        }
    }

    public static int[] findPrimes(int M, int N){
        int[] primes = new int[N];

        for(;;) {
            boolean[] markiert = new boolean[M + 1];
            for (int i = 0; i < markiert.length; i++) {
                markiert[i] = false;
            }

            for (int i = 2; i < markiert.length; i++) {
                for (int j = 2; j <= markiert.length / i; j++) {
                    if (i * j < M)
                        markiert[i * j] = true;
                }
            }

            int primeIndex = 0;
            for (int i = 0; i < markiert.length; i++) {
                if (primeIndex >= N)
                    return primes;
                if (!markiert[i] && i > 1) {
                    primes[primeIndex] = i;
                    primeIndex++;
                }
            }

            M = 10 * M;
        }
    }
}
