
public class SumSplitter extends Thread {
	
	private int[] arr;
	
	private int lo, hi, part;
	
	public int getPartSum() {
		return part;
	}
	
	public void run() {
		part = sum(arr, lo, hi);
	}
	
	public static int sum(int[] arr) {
		return sum(arr,0,arr.length);
	}
	
	public static int sum(int[] arr, int lo, int hi) {
		int total= 0;
		
		for(int i = lo; i < hi; i++) {
			total += arr[i];
		}
		
		return total;
	}

}
