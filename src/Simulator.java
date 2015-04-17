import java.io.*;

class Simulator
{
	public static void main(String args[])
	{
		// Array to Store Test-Case Data
		String[][] testcases = new String[37][9];
		
		// Method returns 2D array which will have all test-cases
		// Method to read Test Cases from input file
		testcases = readFile("D:/Documents/GitHub/Air-Craft-Landing-Simulation/input.csv");
		
	}

	private static  String[][] readFile(String string)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(string)))
		{
			String line;
		    while ((line = br.readLine()) != null)
		    {
		       System.out.println(line);
		    }
		    br.close();
		}
		catch (Exception e)
		{
		    System.err.println(e.getMessage()); // handle exception
		}
		return null;

	}
}