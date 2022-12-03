public class Sieb4 {
	public static boolean[] groesser(boolean[] p) {
		boolean[] newp = new boolean[p.length + 10];
		for (int i = 2; i < p.length; i++) {

			newp[i] = p[i];
		}
		for (int j = p.length - 9; j < p.length; j++) {
			newp[j] = true;

		}

		return newp;
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		boolean[] p = new boolean[9];
		int anzahl = 0, i, j, n;

		for (i = 2; i < p.length; i++) {
			p[i] = true;
		}

		while (anzahl < N) {
			for (i = 2; i * i < p.length; i++) {

				if (p[i]) {
					anzahl++;

					for (n = 2; n * i < p.length; n++)
						p[n * i] = false;
				}
			}
			if (anzahl < N) {
				anzahl = 0;
				groesser(p);
			}
		}
		anzahl = 0;
		for (i = 2; i < p.length; i++) {
			if (p[i]) {
				System.out.println(i + " is prime");
				anzahl++;
				if (anzahl == N) {
					System.exit(-1);
				}

			}

		}

	}

}
