import java.util.*;
import java.lang.*;
class PerfectSquare1
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
PerfectSquare1 obj1=new PerfectSquare1();
boolean b=obj1.isPerfect(n); 
	if(b==true)
	{
		System.out.println(n+"is perfectsquare");
	}
	else
	{
		System.out.println(n+"is not perfectsquare");
	}
}
boolean isPerfect(int n)
{
double x1=Math.floor(Math.sqrt(n));
int x=(int)x1;
if(x*x==n)
{
return true;
}
else
{
return false;
}
}
}
