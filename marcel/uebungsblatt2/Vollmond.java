package marcel.uebungsblatt2;

public class Vollmond {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int n = Integer.parseInt(args[0]);
		int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] monthNames = { "Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };

		findMoons(365, 29, 2, 2022, 1, daysOfMonth, monthNames, n);

		long endTime = (System.currentTimeMillis() - startTime);
		System.out.println("Habe " + n + " Monde in " + endTime + "ms gefunden");
	}

	/**
	 * @param numOfDaysPerYear         Wie viele Tage hat ein Jahr (Ohne, dass es
	 *                                 ein Schaltjahr ist)
	 * @param moonPeriod               In welcher Periode kommt ein Vollmond auf
	 * @param numOfMoonsPerMonthToFind wie viele Vollmonde sollen pro Monat
	 *                                 aufkommen
	 * @param currentYear              Das Aktuelle Jahr
	 * @param startingMoonDayDate      An welchem Tag des Jahres gibt es das erste
	 *                                 mal Vollmond
	 * @param daysOfMonth              Wie viele Tage haben die einzelnen Monate
	 * @param numOfMoonsToFind         Wie viele gesuchte Monate sollen gefunden
	 *                                 werden
	 */
	private static void findMoons(int numOfDaysPerYear, int moonPeriod, int numOfMoonsPerMonthToFind,
			int currentYear, int startingMoonDayDate, int[] daysOfMonth, String[] monthNames, int numOfMoonsToFind) {
		// Die Tage in welchen gilt: die Tage des monats sind < als die Mondperiod.
		// Hierdurch haben wir im konkreten Beispiel jeweils
		// die 1. des Monats in jedem Monat, in denen es 30 Tage gibt
		// und den 1. und 2. in jedem Monat, in denen es 31 Tage gibt
		int[] firstDaysOfMonthsArray = getFirstDaysOfMonthsArray(daysOfMonth, numOfDaysPerYear, moonPeriod,
				numOfMoonsPerMonthToFind);

		int dayDateOfFirstOfMarch = daysOfMonth[0] + daysOfMonth[1];

		int numOfFoundMoons = 0;
		int currentDaysCounter = startingMoonDayDate;

		while (numOfFoundMoons < numOfMoonsToFind) {
			boolean isLeapYear = getLeapYear(currentYear);
			int numOfDaysInCurrentYear = isLeapYear ? 366 : 365;

			boolean corrected = false;
			for (; currentDaysCounter <= numOfDaysInCurrentYear
					&& numOfFoundMoons < numOfMoonsToFind; currentDaysCounter += 29) {
				if (isLeapYear && currentDaysCounter >= dayDateOfFirstOfMarch && !corrected) {
					// Wenn nach 29.2. und derzeit in einem Schaltjahr.
					// Dann müssen wir einen Tag abziehen um den Tag (potenziell) in unserem
					// "firstDaysOfMonthsArray" zu finden
					currentDaysCounter -= 1;
					corrected = true;
				}

				if (isInArray(currentDaysCounter, firstDaysOfMonthsArray)) {
					// Ist ein Doppelvollmond-Monat
					System.out.println(convertDaysToMonth(currentDaysCounter, currentYear, monthNames));
					numOfFoundMoons++;
				}

			}
			// Berichtigung vom Abzug des Tages wenn es ein LeapYear ist und die Schleife nach dem ersten März ist
			if (isLeapYear && corrected)
				currentDaysCounter++;

			// Hier werden die "verbleibenden" Tage der Mondperiode in das kommende Jahr
			// übertragen
			currentDaysCounter = currentDaysCounter - numOfDaysInCurrentYear;
			currentYear++;
		}

	}

	/***
	 * 
	 * @param currentYear welches das Aktuelle Jahr ist
	 * @return Boolean - ob das aktuelle Jahr ein Schaltjahr ist oder nicht
	 */
	private static boolean getLeapYear(int currentYear) {
		return currentYear % 4 == 0 && (!(currentYear % 100 == 0) || currentYear % 400 == 0);
	}

	/***
	 * 
	 * @param months             Integer Array mit den Tagen des Monats
	 * @param numOfDaysInYear    Wie viele Tage hat das Jahr
	 * @param moonPeriod         Wie viele Tage von Vollmond zu Vollmond
	 * @param numOfMoonsPerMonth Wie viele Monde pro Monat suchen wir
	 * @return
	 */
	private static int[] getFirstDaysOfMonthsArray(int[] months, int numOfDaysInYear, int moonPeriod,
			int numOfMoonsPerMonth) {
		// Check ob die Monats-Summe den Tagen des Jahres entspricht
		int checkSum = 0;
		for (int i = 0; i < months.length; i++) {
			checkSum += months[i];
		}
		if (checkSum != numOfDaysInYear)
			return null;
		// Hiernach -> Monate sind korrekt

		// Interessante Tage berechnen
		int[] firstDaysOfMonthsArray = new int[0];
		int currentDaysCounter = 1;
		for (int i = 0; i < months.length; i++) {
			if (months[i] > moonPeriod * (numOfMoonsPerMonth - 1)) {
				for (int j = currentDaysCounter; j < currentDaysCounter + months[i]
						- (moonPeriod * (numOfMoonsPerMonth - 1)); j++) {
					firstDaysOfMonthsArray = addToIntArray(j, firstDaysOfMonthsArray);
					// System.out.println("currently interesting Days: " +
					// Arrays.toString(firstDaysOfMonthsArray));
				}
			}
			currentDaysCounter += months[i];
		}

		return firstDaysOfMonthsArray;
	}

	/**
	 * 
	 * @param i           currentDay vom Jahr (1, ..., 365/366)
	 * @param currentYear Current Year, welches im Return string sein soll
	 * @param monthNames  Array der Namen der Monate (eg Januar, Februar, ...,
	 *                    Dezember)
	 * @return String der Form "currentyear, monthname"
	 */
	private static String convertDaysToMonth(int i, int currentYear, String[] monthNames) {

		int arrayIndex = i / 30;
		if (arrayIndex < monthNames.length)
			return currentYear + ", " + monthNames[arrayIndex];

		return "error";
	}

	/**
	 * 
	 * @param i		Nach welcher Zahl soll im Array gesucht werden
	 * @param array	Array in welchem gesucht werden soll
	 * @return	Boolean - true wenn int i im Array ist, false sonst
	 */
	public static boolean isInArray(int i, int[] array) {
		for (int j = 0; j < array.length; j++) {
			if (array[j] == i)
				return true;
		}
		return false;
	}

	/**
	 * 
	 * @param toAdd     welcher Int soll in das Array hinzugefügt werden
	 * @param prevArray vorheriger int array
	 * @return einen neuen Array, der das neue Element am Ende enthält. Hat eine
	 *         Länge von prevArray.length+1
	 */
	public static int[] addToIntArray(int toAdd, int[] prevArray) {
		int[] retArray = new int[prevArray.length + 1];
		for (int i = 0; i < prevArray.length; i++) {
			retArray[i] = prevArray[i];
		}
		retArray[prevArray.length] = toAdd;

		return retArray;
	}

	// ----------------------------------------------------------------------------------
	// Nicht Genutzt
	// ----------------------------------------------------------------------------------
	/**
	 * 
	 * @param toAdd     welcher String soll in das Array hinzugefügt werden
	 * @param prevArray vorheriger String array
	 * @return einen neuen Array, der das neue Element am Ende enthält. Hat eine
	 *         Länge von prevArray.length+1
	 */
	public static String[] addToStringArray(String toAdd, String[] prevArray) {
		String[] retArray = new String[prevArray.length + 1];

		for (int i = 0; i < prevArray.length; i++) {
			retArray[i] = prevArray[i];
		}
		retArray[prevArray.length] = toAdd;
		return retArray;
	}
}
