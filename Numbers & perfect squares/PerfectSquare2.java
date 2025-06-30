import java.util.*;
import java.lang.*;
class PerfectSquare2
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
PerfectSquare2 obj1=new PerfectSquare2();
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
int start=1,end=n;
	while(start<=end)
	{
	int mid=(start+end)/2;
	if(mid*mid==n)
	{
		return true;
	}
	else if(mid*mid<n)
	{
		start=mid+1;
	}
	else
	{
		end=mid-1;
	}
	}
	return false;
}
}
