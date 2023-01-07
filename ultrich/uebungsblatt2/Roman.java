public class Roman {
 static String roman(int n,String RomanN,int i) { 
	 if(n==0) {
		 return RomanN;
	 }
	 int []a= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	 String []b= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	 if(n>=a[i]) {
		 RomanN+=b[i];
		 n-=a[i];
	 }else {
		 i++;
	 }
	 
	 return roman(n,RomanN,i);
 
  }
 public static void main(String[] args) {
	 if(args.length==0) {
		 System.out.println("Bitte eine Zahl als Parameter angeben. ");
		 System.exit(-1);
	 }
	int N=Integer.parseInt(args[0]) ,i=0;
	String RomanN="";
	 if(N<1||N>5000) {
		 System.out.println("Die Zahl muss zwischen 1 und 5000 liegen.");
		 System.exit(-1);
	 }

assert(1<=N && N<=5000);
System.out.println(roman(N,RomanN,i));
 }
} 
