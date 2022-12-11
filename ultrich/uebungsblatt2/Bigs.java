class Bigs {
 // addiert die Ziffernfelder a und b
 public static int[ ] add (int[ ] a, int[ ] b) {
	 int [] ab;
	 if(a.length>=b.length){
		 ab=new int[a.length];
		 b.length=a.length;
		 for(int i=0;i<ab.length;i++)ab[i]=0;
		
	 }else {
		 ab=new int[b.length];
		 a.length=b.length;
		 for(int i=0;i<ab.length;i++)ab[i]=0;
	 }
	 for(int i=0;i<ab.length;i++) {
			if(i+1<ab.length) {
				ab[i]=(a[i]+b[i]+ab[i])%10 ;
				ab[i+1]=(a[i]+b[i]+ab[i])/10 ;
			}else {
				if(a[i]+b[i]+ab[i]<10) {
					ab[i]=a[i]+b[i]+ab[i];
				}else {
					ab.length+=1;
					ab[i]=(a[i]+b[i]+ab[i])%10 ;
					ab[i+1]=(a[i]+b[i]+ab[i])/10 ;
					break;
					
				}
			}
		 
	 }
	 return ab;
	  }

 // gibt das Ziffernfeld n in lesbarer dezimaler Form aus
 // bei sehr langen Zahlen soll das Format verwendet werden, welches auch von
 // bc (s.u.) benutzt wird: Umbruch nach 68 Ziffern mit einem \ am Ende
 static void print (int[ ] n) { 
	 for(int i=n.length-1;i>=0;i--) {
		 System.out.print(i);
	 }
	  }
 // konstruiert ein einstelliges Ziffernfeld aus der Ziffer d
 static int[ ] digit(int d) { 
	 int []darr= {d};
	 return darr;
 /* TODO */ }

 // konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
 static int[ ] Null() {
	 int []nulll= {0};
 /* TODO */ }

 // konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
 static int[ ] One() { 
	 int []one= {1};
 /* TODO */ }


 // Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
 static int mod10(int[ ] n) {
	int []newn=new int[1];
	newn[0]=n[0];
	return newn[0];
	 /* TODO */ }

 // ganzzahliger Quotient bei Division durch 10
 static int[ ] div10(int[ ] n) {
	 int [] newn=new int[n.length-1];
	 for(int i=0;i<newn.length;i++) {
		 newn[i]=n[i+1];
	 }
	 return newn;
	 /* TODO */ }

 // Umwandlung einer beliebigen int-Zahl in ein Ziffernfeld
 static int[ ] fromInt(int n) { 
	 int []z=new int[0];
	 for(int i=0;n!=0;i++) {
		 z.length+=1;
		 z[i]=n%10;
		 n/=10;
	 }
	 return z;
	 /* TODO */ }

 // kopiert den Wert von n
 static int[ ] copy(int[ ] n) {
int []copn=new int[n.length];
for(int i=0;i<n.length;i++)
	copn[i]=n[i];
 /* TODO */ }

 // multipliziert das Ziffernfeld n mit einer (einstelligen!) int-Zahl
 static int[ ] times(int[ ] n, int d) {
int []timen=new int[n.length];
for(int i=0;i<n.length;i++) {
	timen[i]=0;
}

for(int i=0;i<timen.length;i++) {
	if(i+1<timen.length) {
		timen[i]=(n[i]*d+timen[i])%10 ;
		timen[i+1]=(n[i]*d+timen[i])/10 ;
	}else {
		if(n[i]*d+timen[i]<10) {
			timen[i]=n[i]*d+timen[i];
		}else {
			timen.length+=1;
			timen[i]=(n[i]*d+timen[i])%10 ;
			timen[i+1]=(n[i]*d+timen[i])/10 ;
			break;
			
		}
	}
}
return timen;
 /* TODO */ }

 // multipliziert das Ziffernfeld n mit 10
 static int[ ] times10(int[ ] n) { 
	 int []t10=new int[n.length+1];
	 t10[0]=0;
	 for(int i=0;i<n.length;i++) {
		 t10[i+1]=n[i];
	 }
	 return t10;
 /* TODO */ }

 // multipliziert zwei Ziffernfeld
 static int[ ] times(int[ ] a, int[ ] b) {
	 int []times=new int [a.length];
	 int an=0;
	 int []arra=fromInt(an);
	 int c=compareArrays(b,arra);
			 for(int i=1;c!=1;i++) {
				  an++;
				  arra=fromInt(an);
				  times=add(times,a);
				  c=compareArrays(b,arra);
				 
				
			 }
			 return times;
 
 
 /* TODO */ }
 
 
 public static int compareArrays(int[] array1, int[] array2) {
     boolean b = true;
     int a=1;
     if (array1 != null && array2 != null){
       if (array1.length != array2.length)
           b = false;
       else
           for (int i = 0; i < array2.length; i++) {
               if (array2[i] != array1[i]) {
                   b = false;   
                   a=0;
               }                 
         }
     }else{
       b = false;
       a=0;
     }
     return a;
     
    
 }
 
 
 
 

 // Quadratzahl eines Ziffernfeldes
 static int[ ] square(int[ ] a) {
	 int []squarea=times(a,a);
	 
			 return squarea;
 /* TODO */ }

 // Kubikzahl eines Ziffernfeldes
 static int[ ] cubic(int[ ] a) {
	 int []cubica=new int[a.length];
	 for(int i=0;i<a.length;i++) {
		 cubica[i]=a[i];
	 }
	 for(int i=0;i<=1;i++) {
		 cubica=times(cubica,a);
	 }
 /* TODO */ }

 // Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
 static boolean less (int[ ] a, int[ ] b) {
	 boolean less=true;
	
		 if(a.length>b.length) {
			 less=false;
		 }
		 if(a.length==b.length) {
			 for(int i=a.length-1;i>=0;i--) {
				 if(a[i]<b[i]) {
					 break;
				 }
				 if(a[i]>b[i]) {
					 less=false;
					 break;
				 }
					 
			 
			 }
		 }
	 
	 return less;
 /* TODO */ }

 // Test auf Gleichheit zweier Ziffernfelder
 static boolean equal (int[ ] a, int[ ] b) {
	 
	 boolean equal=true;
	 if(a.length<b.length) {
		 equal=false ;
	 }else {
		 if(a.length>b.length) {
			 equal=false;
		 }
		 if(a.length==b.length) {
			 for(int i=a.length-1;i>=0;i--) {
				 if(a[i]<b[i]) {
					 equal=false;
					 break;
				 }
				 if(a[i]>b[i]) {
					 equal=false;
					 break;
				 }
					 
			 
			 }
		 }
	 }
	 return equal;
 
 /* TODO */ }

 // Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
 // mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
 // keine fuehrenden Nullen (ausser bei Null selbst)
 static boolean ok (int[ ] n) { 
	 boolean ok=true ;
	 for(int i=0;i<n.length;i++) {
		 if(n[i]<0||n[i]>9) {
			 ok=false;
			 break;
		 }
		 if(n.length!=1&&i==n.length-1&&n[i]==0) {
			 ok=false;
		 }
	 }
	 return ok;
 
 /* TODO */ }

 // gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus
 static void maxDigit(int[] n) {
	 int l=0,m=0;
	 boolean []compar=new boolean[n.length];
	 for(int i=0;i<compar.length;i++) {
		 compar[i]=true;
	 }
	 int []zaehler=new int[n.length];
	 
	 for(int i=0;i<n.length;i++) {
		 for(int j=0;j<n.length;j++) {
			 if(n[i]==n[j]&&compar[i]==true) {
				 m++;
				 compar[j]=false;
				 
			 }
		 }
		 zaehler[i]=m;
		 m=0;
		 
	 }
	 int max=zaehler[0];
	 int minarr;
	 for(int i=0;i<zaehler.length;i++) {
		 if(zaehler[i]>max) {
			 max=zaehler[i];
			 minarr=n[i];
		 }
	 }
	
	 for(int i=0;i<n.length;i++) {
		 if(max==zaehler[i]&&minarr>n[i]) {
			 minarr=n[i];
		 }
	 }
	 System.out.println(minarr);
 /* TODO */ }

 public static void main (String[] s) {
 int[ ] a = One();
 for (int i=0; i<33222; ++i) { a = times(a, 2); }
 System.out.println("2^33222 hat " + a.length + " Stellen");
 print(a);
 System.out.println();
 int[ ] b = fromInt(13);
 int[ ] c = copy(b);
 for (int i=1; i<8978; ++i) { c = times(c, b); }
 System.out.println("13^8978 hat " + c.length + " Stellen");
 print(c);
 System.out.println();
 System.out.println(less(a, c)); // beantwortet die Frage aus der
 // Aufgabenueberschrift
 maxDigit(a);
 maxDigit(c);
 }
}
