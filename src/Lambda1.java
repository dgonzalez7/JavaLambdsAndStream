import java.util.Arrays;

public class Lambda1 
{

	public static void main(String[] args) 
	{
		String[] testStrings = {"one", "two", "three", "four"};
		printArray(testStrings);
		
		// Example:  (var1, var2, ...) -> { return(something) }
		Arrays.sort(testStrings, 
				(s1, s2) -> { return(s1.length() - s2.length()); }
				);

		System.out.println();
		printArray(testStrings);
		
		
		String[] testStrings2 = {"one", "two", "three", "four"};
		System.out.println();
		printArray(testStrings2);
		
		// Example:  (var1, var2, ...) -> something
		Arrays.sort(testStrings2, 
				(s1, s2) -> s1.length() - s2.length()
				);
		
		System.out.println();
		printArray(testStrings2);
	}
	
	private static void printArray(String[] s)
	{
		for (int i = 0; i < s.length; i++)
		{
			System.out.println(s[i]);
		}
	}

}