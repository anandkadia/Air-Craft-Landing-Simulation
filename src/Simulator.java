import java.io.*;

class Simulator
{
	public static void main(String args[])
	{
		// Array to Store Test-Case Data
		String[][] testcases = new String[37][12];
		
		// Method returns 2D array which will have all test-cases
		// Method to read Test Cases from input file
		testcases = readFile("D:/Documents/GitHub/Air-Craft-Landing-Simulation/input.txt");
		
		//THE LOOP 37 Times
		for(int i=0; i<37; i++)
		{
			for(int j=0; j<12; j++)
			{
				System.out.print(testcases[i][j]+"\t");
			}
			System.out.println();
		}
		
		
	}

	private static String[][] readFile(String string)
	{
		String [][] testcase = new String[37][12];
		try (BufferedReader br = new BufferedReader(new FileReader(string)))
		{
		    String line;
		    
			for(int i = 0;i<37;i++)
			{
				line = br.readLine();
				int j = 0;
				for (String part : line.split("\t")) 
				{
					testcase[i][j] = part;
					j++;
				}
			}
		    br.close();
		}
		catch (Exception e)
		{
		    System.err.println(e.getMessage()); // handle exception
		}
		return testcase;
	}
}