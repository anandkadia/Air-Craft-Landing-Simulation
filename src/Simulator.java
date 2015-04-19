import java.io.*;

class Simulator
{
	static int totalFailedOutput = 0;
	public static void main(String args[])
	{
		// Array to Store Test-Case Data
		String[][] testcases = new String[37][12];
		
		// Reading file and storing data into testcases
		testcases = readFile("D:/Documents/GitHub/Air-Craft-Landing-Simulation/input.txt");
		
		//THE LOOP - 37 Times
		for(int i=0; i<37; i++)
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
			if(testcases[i][10].equals("X"))
				gearOverrideWarning = true;
			
			boolean gearUpCommand = false;
			if(testcases[i][11].equals("X"))
				gearUpCommand = true;
			
			computeSimulationState(testCaseNumber, expectedScenario, speed, gearDown, altitude, time, gearNotDownAlarm, gearAirSpeedAlarm, airBrakeWarning, gearOverrideWarning, gearUpCommand);
		}
		System.out.println();
	}


	private static void computeSimulationState(int testCaseNumber,
			int expectedScenario, int speed, boolean gearDown, int altitude,
			int time, boolean gearNotDownAlarm, boolean gearAirSpeedAlarm,
			boolean airBrakeWarning, boolean gearOverrideWarning,
			boolean gearUpCommand) 
	{
		
		int displayScenario = 99;
		
		// Conditions to decide display scenario
		System.out.println(testCaseNumber+"\t"+expectedScenario+"\t"+speed+"\t"+gearDown+"\t"
							+altitude+"\t"+time+"\t"+gearNotDownAlarm+"\t"+gearAirSpeedAlarm+"\t"
							+airBrakeWarning+"\t"+gearOverrideWarning+"\t"+gearUpCommand);
		
		 if(gearNotDownAlarm == true && gearAirSpeedAlarm == false && airBrakeWarning == true && gearOverrideWarning == false && gearUpCommand == false)
		 {
			 displayScenario = 1;
			 if(displayScenario != expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(gearNotDownAlarm == false && gearAirSpeedAlarm == true && airBrakeWarning == true && gearOverrideWarning == true && gearUpCommand == true)
		 {
			 displayScenario = 2;
			 if(displayScenario != expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(gearNotDownAlarm == true && gearAirSpeedAlarm == false && airBrakeWarning == false && gearOverrideWarning == false && gearUpCommand == false)
		 {
			 displayScenario = 3;
			 if(displayScenario != expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(gearNotDownAlarm == false && gearAirSpeedAlarm == true && airBrakeWarning == false && gearOverrideWarning == true && gearUpCommand == true)
		 {
			 displayScenario = 4;
			 if(displayScenario != expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(gearNotDownAlarm == false && gearAirSpeedAlarm == true && airBrakeWarning == true && gearOverrideWarning == false && gearUpCommand == false)
		 {
			 displayScenario = 5;
			 if(displayScenario != expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(gearNotDownAlarm == false && gearAirSpeedAlarm == true && airBrakeWarning == false && gearOverrideWarning == false && gearUpCommand == false)
		 {
			 displayScenario = 6;
			 if(displayScenario != expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(gearNotDownAlarm == false && gearAirSpeedAlarm == false && airBrakeWarning == true && gearOverrideWarning == false && gearUpCommand == false)
		 {
			 displayScenario = 7;
			 if(displayScenario != expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(gearNotDownAlarm == false && gearAirSpeedAlarm == false && airBrakeWarning == false && gearOverrideWarning == false && gearUpCommand == false)
		 {
			 displayScenario = 8;
			 if(displayScenario != expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
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