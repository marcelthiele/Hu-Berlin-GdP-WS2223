package ultrich.uebungsblatt2;


public class FlugSimulator2 {

	public static void main(String[] args) {
		int anzahlFluege = Integer.parseInt(args[0]);
		double Mittelwert , u ;
		int ub=0;
		int[] reiser=new int [78];
		int[] summe=new int [anzahlFluege];
		int Allsumme=0;
		int i , j ;

		if(anzahlFluege>=1) {
			for(j=0;j<anzahlFluege;j++) {
			for(i=0;i<78;i++) {
				if(Math.random()<0.08) {
					reiser[i]=0;
                        
					
				}else {
					reiser[i]=1;
					summe[j]+=reiser[i];
                        
				}
			}
			
			Allsumme+=summe[j];
			i=0;
			
		}
			for(j=0;j<anzahlFluege;j++) {
				if(summe[j]>75) {
					ub++;
				}
			}
			u=(double)Math.round((((double)ub)/((double)anzahlFluege))*10000)/10000.00;
			Mittelwert=(double)Math.round(((((double)Allsumme)/((double)anzahlFluege)))*10)/100.0;
			System.out.println("Überbuchungen : "+ub+" ("+100*u+"%)");
			System.out.println("Mittelwert : "+10*Mittelwert);
			
			

	}

}
}