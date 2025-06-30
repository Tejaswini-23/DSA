import java.util.*;
class Prime3
{
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	Prime3 obj1=new Prime3();
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
	int c=0;
	for(int i=1;i*i<=n;i++)
	{
		if(n%i==0)
		{
		c++;
		if(n/i!=i)
		{
		c++;
		}
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
