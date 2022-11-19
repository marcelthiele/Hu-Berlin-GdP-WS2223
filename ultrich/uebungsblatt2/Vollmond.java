package ultrich.uebungsblatt2;
public class Vollmond{
public static void main(String[] args) {
   int n = Integer.parseInt(args[0]);
int jahr=2022;
String[] monat={"Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
int[] tage={31,28,31,30,31,30,31,31,30,31,30,31};

int i=0 ;
int t=1 ;    //"t" representiert den Tag des Monates ,indem es vollmond gibt. Am anfang sind wir bei 1ste Januar 2022
int e=30 ;   //"e" sagt uns wie viel Tage bleibt bis ende des Monates
int j=0 ;    //"j" ist die anzahl der Monaten ,indem es zweimal Vollmond gibt

while(j<n) {
	if(t+29<=tage[i]) {  //wenn es zwei mal vollmond gibt , dann bleiben wir in der selben Monat 29 Tage später nach der ersten
		System.out.println(jahr+", "+monat[i]) ;
		j++;
		e=tage[i]-t-29;    //wenn es wahr ist nun rechnen wir hier der neuen wert von "e"
		i++;               //dann weiter zu dem nächste Monat
		if(i>11) {         //hier gucken wir ob unsere Array von 12 elemente durch sind, d.h Dezember durch ist,wenn ja
			               //so gehen wir wieder bei Januar 
			i=0;
			jahr++;        //so addieren wir ein Jahr dazu
			if(jahr%4==0&&jahr%100!=0||jahr%4==0&&jahr%400==0) {    //wir gucken hier, ob wir schaltjahr haben oder nicht
				tage[1]=29;
			}else {
				tage[1]=28;
			}
		}
		t=29-e;    // so dann können wir wissen in welche tage des nächsten Monaten , wir sein werden
		if(t>tage[i]) {  //es gibt aber Fälle sodass ein Monat Komplet gesprungen wird,das passiert 
			             //wenn in der letzen Monat zwei mal Vollmond gabt meisten Februar<30 Tage
			t-=tage[i];  //wenn es der Fall ist nehmen wir den wert von t-anzahl des tages von der getroffenen Monat
			i++;         //dann gehen wir in der nächsten Monat weiter
			
		}
	}else {
		e=tage[i]-t;  // da wir diese Monat nur einmal Vollmond haben werden rechnen wir den neuen wert von "e"
		i++;          //usw...
		if(i>11) {
			i=0;
			jahr++;
			if(jahr%4==0&&jahr%100!=0||jahr%4==0&&jahr%400==0) {
				tage[1]=29;
			}else {
				tage[1]=28;
			}
		}
		t=29-e;
	}
}
}
}