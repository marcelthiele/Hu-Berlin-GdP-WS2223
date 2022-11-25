public class Nolindrom {

	public static void main(String[] args) {
	long	N=Integer.parseInt(args[0]);
		
		long n , r=0 , b ;
		long t=12;
		int i=0 , j=0;
		
while(t<=N) {
	
	for(n=t;n!=r;n=n+r) {

		for(;n!=0;n/=10) {
			b=n%10;
			r=r*10+b;
		}
		i++;
		if(i==101&&n!=r) {
			System.out.println(n);
			break;
		}
	}
	i=0;
	n=++t;
     r=0;
     }
	
  }

}
