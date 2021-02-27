import java.util.Scanner;

public class Fibb_Iterative {
	
static int Fibb_Iterate(int n) {
		if(n == 0)return 0;
		int init = 0; 
		int prev = 1;
		int curr;
		for(int j = 1; j < n; j++) {
			curr= init+ prev;	
			init = prev;
			prev = curr;
		}
		return prev;
	}

	public static void main(String[] args) {
		int x;
		Scanner num = new Scanner(System.in);
		
		System.out.println("enter a number");
		x = num.nextInt();
		long starttime = System.nanoTime();
		for (int k = 0; k < x; k++) {
			Fibb_Iterate(k);
			System.out.println(Fibb_Iterate(k));
		}
		long endtime = System.nanoTime();
		long elapseTime = endtime-starttime;
		
		System.out.println("Elapsed Time: " +elapseTime+" nanoseconds" );
	}

}
