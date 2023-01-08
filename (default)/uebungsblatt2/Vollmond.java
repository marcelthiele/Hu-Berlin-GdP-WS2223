public class Vollmond {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int jahr = 2022;
		String[] monat = { "Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };
		int[] tage = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int i = 0;
		int t = 1; // "t" repräsentiert den Tag des Monats, indem es Vollmond gibt. Wir fangen am 1. Januar an
		int e = 30; // "e" sagt uns wie viele Tage bis zum Ende des Monats bleiben
		int j = 0; // "j" ist die Anzahl der Monate, indem es zweimal Vollmond gibt

		while (j < n) {
			if (t + 29 <= tage[i]) { // wenn es zwei mal vollmond gibt, dann bleiben wir in dem selben Monat 29 Tage später nach dem ersten Vollmond
				
				System.out.println(jahr + ", " + monat[i]); // <---- Hier wird das Ergebnis ausgegeben
				
				j++;	// Wir erhöhen die Anzahl der gefunden Monate um 1
				e = tage[i] - t - 29; // Wenn wir in einem Doppelvollmond-Monat sind, verbleiben e tage bis zum Ende des Monats
				i++; // Wir erhöhen den Monats-Index um 1
				if (i > 11) { // hier gucken wir ob unser Array von 12 elemente durch ist, d.h Dezember > 11
					i = 0;// Dann setzen wir den Monats-index zurück auf Januar
					jahr++; // und addieren ein Jahr dazu
					if (jahr % 4 == 0 && jahr % 100 != 0 || jahr % 4 == 0 && jahr % 400 == 0) { 
						//Ist schaltjahr
						tage[1] = 29; 	//Februar hat 29 Tage
					} else {
						//ist kein Schaltjahr
						tage[1] = 28; //Februar hat 28 Tage
					}
				}
				t = 29 - e; // der tag des nächsten Monats ergibt sich aus dem Rest des letzten Monats "e" und der Mondperiode 29
				if (t > tage[i]) { // es gibt aber Fälle, sodass ein Monat Komplett übersprungen wird. Das passiert,
									// wenn es in dem letzen Monat zwei mal Vollmond gab. Meisten Februar = 28 Tage
					t -= tage[i]; // wenn der Monat übersprungen wird, errechnen wir t = t - "anzahl der tage vom aktuellen Monat"
					i++; // dann gehen wir einen Monat weiter

				}
			} else {
				// Wir haben nur ein mal Vollmond in diesem Monat
				e = tage[i] - t; // Der "Rest" des Monats "e" ist also das Ergebnis aus der Anzahl der Tage des aktuellen Monats minus die "verbleibenden Tage" "t" aus dem letzten Monat
				i++; // Wir gehen in den Nächsten Monat
				if (i > 11) {
					//s.o
					i = 0;
					jahr++;
					if (jahr % 4 == 0 && jahr % 100 != 0 || jahr % 4 == 0 && jahr % 400 == 0) {
						tage[1] = 29;
					} else {
						tage[1] = 28;
					}
				}
				t = 29 - e;
			}
		}
	}
}