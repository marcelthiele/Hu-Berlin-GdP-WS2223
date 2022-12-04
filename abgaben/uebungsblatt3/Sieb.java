public class Sieb {
	public static boolean[] groesser(boolean[] p) {
		boolean[] newp = new boolean[p.length * 10];
		for (int j = 0; j < newp.length; j++) {
			newp[j] = true;

		}
		for (int i = 2; i < p.length; i++) {

			newp[i] = p[i];
		}

		return newp;
	}

	public static void main(String[] args) {
		if(args.length==0){
			System.out.println("Bitte geben Sie eine Zahl ein.");
			System.exit(-1);
		}
		int N = Integer.parseInt(args[0]);
		if(N<1){
			if(N==0){
				System.out.println("keine Prime Zahl für Eingabe 0.");
			}
			System.out.println("Bitte geben Sie eine positive ganze Zahl ein.");
			System.exit(-1);
		}
		boolean[] p = new boolean[9];
		int anzahl = 0;

		for (int i = 2; i < p.length; i++) {
			p[i] = true;
		}

		while (anzahl < N) {
			for (int i = 2; i < p.length; i++) {

				if (p[i]) {
					anzahl++;

					for (int n = 2; n * i < p.length; n++)
						p[n * i] = false;
				}
			}
			if (anzahl < N) {
				p = groesser(p);
			}
		}
		anzahl = 0;
		for (int i = 2; i < p.length; i++) {
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
