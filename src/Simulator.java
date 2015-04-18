import java.io.*;

class Simulator
{
	public static void main(String args[])
	{
		// Array to Store Test-Case Data
		String[][] testcases = new String[37][12];
		
		// Reading file and storing data into testcases
		testcases = readFile("D:/Documents/GitHub/Air-Craft-Landing-Simulation/input.txt");
		
		//THE LOOP - 37 Times
		for(int i=0; i<37; i++)
		{
			for(int j=0; j<12; j++)
			{
				int testCaseNumber = Integer.parseInt(testcases[i][0]);
				
				int expectedScenario = Integer.parseInt(testcases[i][2]);
				
				int speed = Integer.parseInt(testcases[i][3]);
				
				boolean gearDown = false;
				if(testcases[i][4].equals("Y"))
					gearDown = true;
				
				int altitude = Integer.parseInt(testcases[i][5]);
				
				int time = Integer.parseInt(testcases[i][6]);
				
				boolean gearNotDownAlarm = false;
				if(testcases[i][7].equals("X"))
					gearNotDownAlarm = true;
				
				boolean gearAirSpeedAlarm = false;
				if(testcases[i][8].equals("X"))
					gearAirSpeedAlarm = true;
				
				boolean airBrakeWarning = false;
				if(testcases[i][9].equals("X"))
					airBrakeWarning = true;
				
				boolean gearOverrideWarning = false;
				if(testcases[i][10].equals("Y"))
					gearOverrideWarning = true;
				
				boolean gearUpCommand = false;
				if(testcases[i][11].equals("Y"))
					gearUpCommand = true;
				
				computeSimulationState(testCaseNumber, expectedScenario, speed, gearDown, altitude, time, gearNotDownAlarm, gearAirSpeedAlarm, airBrakeWarning, gearOverrideWarning, gearUpCommand);
				//System.out.print(testcases[i][j]+"\t");
			}
			System.out.println();
		}
		
		
	}


	private static void computeSimulationState(int testCaseNumber,
			int expectedScenario, int speed, boolean gearDown, int altitude,
			int time, boolean gearNotDownAlarm, boolean gearAirSpeedAlarm,
			boolean airBrakeWarning, boolean gearOverrideWarning,
			boolean gearUpCommand) {
		
		/*intializing all parameters for computeSimulaionState method
		int testCaseNumber1 = testCaseNumber;
		int expectedScenario = expectedScenario;
		int speed = speed; 
		boolean gearDown = gearDown;
		int altitude = altitude;
		int time = time;
		boolean gearNotDownAlarm = gearNotDownAlarm; 
		boolean gearAirSpeedAlarm = gearAirSpeedAlarm;
		boolean airBrakeWarning = airBrakeWarning;
		boolean gearOverrideWarning = gearOverrideWarning;
		boolean gearUpCommand = gearUpCommand; */
		
		// Conditions to decide display scenario
		
		
		
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