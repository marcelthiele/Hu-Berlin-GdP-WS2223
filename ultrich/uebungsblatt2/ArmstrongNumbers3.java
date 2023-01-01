public class ArmstrongNumbers3{
	public static boolean isArmstrongNumbers(int number) {
		
		int j=number,i=0;
		int []b;
		if(number==0) {
			b=new int[1];
		}else {
			b=new int[(int)Math.floor(Math.log10(j)+1)];
		}
		
		do {
			b[i]=j%10;
			j/=10;
			i++;
		}while(j!=0);
		int numberP=0 ;
		for( i=0; i<b.length; i++) {
			numberP+=Math.pow(b[i], b.length);
		}
		if(number==numberP) {
			return true;
		}
		return false;
	}
	


	public static int[] giveArmstrongNumbers(int n) {
		int anzahl=0 ;
		int []ArmstrongNumbers=new int[n];
		for(int i=0;anzahl<n;i++) {
			if(isArmstrongNumbers(i)) {
				ArmstrongNumbers[anzahl]=i;
				anzahl++;
			}
		}
		return ArmstrongNumbers;
	}
	public static void main(String[] args) {
		int n=Integer.parseInt(args[0]);
		int [] ArmstrongNumbers;
		ArmstrongNumbers=giveArmstrongNumbers(n);
		
		for(int i : ArmstrongNumbers) {
			if(i==ArmstrongNumbers[ArmstrongNumbers.length-1]) {
				System.out.print(i);
				break;
			}
			System.out.print(i+", ");
		}
	
	}

}
