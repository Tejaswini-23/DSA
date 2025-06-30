import java.util.*;
import java.io.*;
class Fibo
{
	static int nfibo(int n)
	{
	  int a=0,b=1,c=0;
	   if(n==0){
		return a;
	   }
	   if(n<=2){
	        return b;
	   }
	  for(int i=3;i<=n;i++){
		c=(a+b)%1000000007;
		a=b;
		b=c;
	  }
	  return c;
	}

        public static void main(String args[])
	{
	  Scanner sc=new Scanner(System.in);
	  int n=sc.nextInt();
	  Fibo obj=new Fibo();
	  System.out.println(obj.nfibo(n));
	}
}
