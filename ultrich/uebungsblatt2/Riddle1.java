public class  Riddle {
  // Die Methode gibt "keine Lösung" aus, wenn es keine Lösung gibt,
  // ansonsten gibt sie alle Lösungen aus (für N < 10) oder
  // die Anzahl der Lösungen (für N >= 10).
	 public static void main(String[] args) { 
		 int n=Integer.parseInt(args[0]);
		 solve(n);
	 }
		public static void solve(int n) {
		 
    int[] field = new int[2 * n]; // Das Feld, das wir auffüllen wollen
    int count = solveRecursive(field, 0, n); // Rekursive Hilfmethode aufrufen
    if (count == 0) {
      System.out.println("keine Lösung");
    } else {
      if (n < 10) {
        // Wenn N < 10, dann alle Lösungen ausgeben
        for (int i = 0; i < count; i++) {
          for (int j = 0; j < field.length; j++) {
            System.out.print(field[j] + " ");
          }
          System.out.println();
        }
      }
      // Die Anzahl der Lösungen ausgeben
      System.out.println(count + " Lösungen gefunden");
    }
  }

  // Die rekursive Hilfmethode füllt das Feld Stück für Stück auf
  // und gibt die Anzahl der gefundenen Lösungen zurück.
 
  
  private static int solveRecursive(int[] field, int pos, int n) {
    // Wenn wir am Ende des Feldes angekommen sind,
    // dann haben wir eine Lösung gefunden.
    if (pos == field.length) {
      return 1;
    }

    int count = 0; // Anzahl der Lösungen
    for (int i = 1; i <= n; i++) {
      // Wir versuchen, die Zahl i an diese Stelle zu setzen
      if (isPossible(field, pos, i, n)) {
        // Wenn es möglich ist, dann setzen wir die Zahl und
        // rufen die Methode rekursiv mit dem nächsten Feld auf
        field[pos] = i;
        count += solveRecursive(field,pos+1,n) ;
        //to do
        field[pos]=0;
      }
    }
    return count;
    
  }
      
      public static boolean isPossible(int []field, int pos, int i,int n) {
    	  if(pos+i+1<2*n) {
    		  if(field[pos]!=0||field[pos+i+1]!=0) {
        		  return false;
        	  }
    		  for(int j=pos+1;j+1<=pos+i;j++) {
    			  for(int t=pos+1;t+1<=pos+i;t++) {
    				  if(field[j]==field[t]&&field[j]!=0) {
    					  return false;
    				  }
    			  }
    		  }
    	  }
    	  
    	  
    	  return true;
      }
}