
public class TimeMeasureTool {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		/* 	Call method here whose execution time to be measured. 
			This can be a method from another class. Demonstration purpose 
			a method of this class is called and execution time is printed.
		*/
		printMessage();
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		System.out.println("\nElapsed time in Nano second : "+elapsedTime);
	}

	private static void printMessage() {
		for(int i =0; i <10;i++) {
			System.out.print(" "+i);
		}
	}
}
