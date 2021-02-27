import java.util.*;
public class Fibb_Recursive {
	
	public static int Fibb_Recurse(int n) {
		
		if(n == 0)
		{
			return 0;
		}else if (n == 1)
		{
			return 1;
		}else
		{
			return (Fibb_Recurse(n-1) + Fibb_Recurse(n-2));
		}
		
	}

	public static void main(String[] args) {
		int f = 0;
		Scanner key = new Scanner(System.in);
		
		System.out.println("enter a number");
		f = key.nextInt();
		
		long starttime = System.nanoTime();
		for(int i = 0; i <f; i++) {
			Fibb_Recurse(i);
			System.out.println(Fibb_Recurse(i));
		}
		long endtime = System.nanoTime();
		long elapseTime = endtime-starttime;
		
		System.out.println("Elapsed Time: " +elapseTime+" nanoseconds" );

	}

}
