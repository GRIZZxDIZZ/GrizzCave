import java.util.Scanner;

public class Fibb_Iterative {
	
static int Fibb_Iterate(int n) {
	//base case
		if(n == 0)return 0;
		
		int init = 0; 
		int prev = 1;
		int curr;
		//for n times, a fibonacci number is calculated
		for(int j = 1; j < n; j++) {
			curr= init+ prev;	
			init = prev;
			prev = curr;
		}
		//returns nth fib number
		return prev;
	}

	public static void main(String[] args) {
		int x;
		Scanner num = new Scanner(System.in);
		//enter n
		System.out.println("enter a number");
		x = num.nextInt();
		//start timer
		long starttime = System.nanoTime();
		//run the fib sequence for each k, x times
		for (int k = 0; k < x; k++) {
			Fibb_Iterate(k);
			System.out.println(Fibb_Iterate(k));
		}
		//stop timer and calculate time elapsed
		long endtime = System.nanoTime();
		long elapseTime = endtime-starttime;
		//print results
		System.out.println("Elapsed Time: " +elapseTime+" nanoseconds" );
	}

}
