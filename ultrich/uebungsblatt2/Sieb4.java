public class Sieb4 {
	public static boolean[] groesser(boolean[] p) {
		boolean[] newp = new boolean[p.length * 10];
		for (int j = 0; j < newp.length; j++) {
			newp[j] = true;

		}
		for (int i = 2; i < p.length && i < newp.length; i++) {

			newp[i] = p[i];
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
			for (i = 2; i < p.length; i++) {

				if (p[i]) {
					anzahl++;

					for (n = 2; n * i < p.length; n++)
						p[n * i] = false;
				}
			}
			if (anzahl < N) {
				p = groesser(p);
				anzahl=0;
			}
		}
		anzahl = 0;
		for (i = 2; i < p.length; i++) {
			if (p[i]) {
				System.out.println(i);
				anzahl++;
				if (anzahl == N) {
					System.exit(-1);
				}

			}

		}

	}

}
