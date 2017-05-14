package coreservlets.timing;

@FunctionalInterface
public interface Op2
{	
	void runOp();

	public static void timeOp2(Op2 operation) 
	{
		double ONE_BILLION = 1_000_000_000;

		long startTime = System.nanoTime();
		operation.runOp();
		long endTime = System.nanoTime();
		double elapsedSeconds = (endTime - startTime)/ONE_BILLION;
		System.out.printf("  Elapsed time: %.3f seconds.%n", elapsedSeconds);
	}
	
	default Op2 combinedOp2(Op2 secondOp) 
	{
		return (() -> 
		{	
			runOp();
			secondOp.runOp();
		});
	}
}
