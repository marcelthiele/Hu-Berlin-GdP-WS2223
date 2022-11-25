public class Nolindrom3 {

	public static void main(String[] args) {
	if(args.length==0) {
		System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
		System.exit(-1);
	}
	    long N=Long.parseLong(args[0]);	
	    if(N>100000) {
	    	System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
          System.exit(-1);
	    }
		long num=1 , n=num , r=0 , b=0 , i=0 , j ;
		
while(num<=N) {
		n=num;
		r=0;
while(n!=r) {
	if(Long.MAX_VALUE-r<n) {
		
		break;
	}
         n=n+r;
         r=0;
         

		for(j=n;j!=0;j/=10) {
			b=j%10;
			if((Long.MAX_VALUE-b)/10<r) {
				
				break;
			}
			r=r*10+b;
               
		}
		if((Long.MAX_VALUE-b)/10<r)break;
                   
           i++;
           if(i==100) {
        	   
        	   break;
           }
          
	}
if(n!=r) {
	System.out.println(num);
}
    i=0;
	num++;
    }
  }

}