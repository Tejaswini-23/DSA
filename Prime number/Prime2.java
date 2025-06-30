import java.util.*;
class Prime2
{
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	Prime2 obj1=new Prime2();
	boolean b=obj1.isPrime(n);
	if(b==true)
	{
		System.out.println(n+"is prime");
	}
	else
	{
		System.out.println(n+"is not prime");
	}
}
boolean isPrime(int n)
{
	int c=1;
	for(int i=1;i<=n/2;i++)
	{
		if(n%i==0)
		{
		c++;
		}
	}
	if(c==2)
	{
	return true;
	}
	else
	{
	return false;
	}	
}
}
