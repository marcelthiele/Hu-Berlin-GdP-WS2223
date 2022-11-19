package marcel.uebungsblatt2;

public class Flugsimulation {
	public static void main(String[] args) {
		double fluggastErscheintWahrscheinlichkeit = 0.92;

		int flugplaetzeProFlugzeug = 75;

		int verkaufteFlugplaetzeProFlugzeug = 78;

		int numOfSimulations = Integer.parseInt(args[0]);

		int numOfUeberbuchungen = 0;
		int sumOfBuchungen = 0;
		for (int i = 0; i < numOfSimulations; i++) {
			int anzahlPassagiereDieKommen = 0;
			for (int j = 0; j < verkaufteFlugplaetzeProFlugzeug; j++) {
				anzahlPassagiereDieKommen += Math.random() > fluggastErscheintWahrscheinlichkeit ? 0 : 1;
			}
			if (anzahlPassagiereDieKommen > flugplaetzeProFlugzeug)
				numOfUeberbuchungen++;
			sumOfBuchungen += anzahlPassagiereDieKommen;
		}

		double percentageOfUeberbuchungen = ((double) numOfUeberbuchungen / (double) numOfSimulations) * 100;
		double mittelWertBuchungen = ((double) sumOfBuchungen) / ((double) numOfSimulations);
		System.out.println("Überbuchungen: " + numOfUeberbuchungen + " ("
				+ String.format("%.2f", percentageOfUeberbuchungen) + "%)");
		System.out.println("Mittelwert: " + String.format("%.1f", mittelWertBuchungen));
	}
}
