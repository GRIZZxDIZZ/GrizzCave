import java.util.Random;

public class ParallelSums {
	
	static int n = 200000000;
	
	public static void main(String[] args) {
		int[] dataNP = new int[n];
		Random rand = new Random();
		int limit = 11;
		int sum = 0;
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			dataNP[i] = rand.nextInt(limit);
			if(dataNP[i] > limit-1||dataNP[i] < 0 ) {
				System.out.println("Oops");
			}
			sum += dataNP[i];
		}
		
		System.out.println("Time elapsed: " + (System.currentTimeMillis() - start));
		System.out.println("Total: "+sum);
	}
}
