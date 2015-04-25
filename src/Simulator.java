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
		
		DisplayValue DV = new DisplayValue();
		//THE LOOP - 37 Times
		for(int i=0; i<37; i++)
		{
			DV.testCaseNumber = Integer.parseInt(testcases[i][0]);
			DV.expectedScenario = Integer.parseInt(testcases[i][2]);
			DV.speed = Integer.parseInt(testcases[i][3]);
			DV.gearDown = false;
			if(testcases[i][4].equals("Y"))
				DV.gearDown = true;
			
			DV.altitude = Integer.parseInt(testcases[i][5]);
			DV.time = Integer.parseInt(testcases[i][6]);
			DV.gearNotDownAlarm = false;
			if(testcases[i][7].equals("X"))
				DV.gearNotDownAlarm = true;
			
			DV.gearAirSpeedAlarm = false;
			if(testcases[i][8].equals("X"))
				DV.gearAirSpeedAlarm = true;
			
			DV.airBrakeWarning = false;
			if(testcases[i][9].equals("X"))
				DV.airBrakeWarning = true;
			
			DV.gearOverrideWarning = false;
			if(testcases[i][10].equals("X"))
				DV.gearOverrideWarning = true;
			
			DV.gearUpCommand = false;
			if(testcases[i][11].equals("X"))
				DV.gearUpCommand = true;
			
			computeSimulationState(DV);
		}
		System.out.println();
	}


	private static void computeSimulationState(DisplayValue DV) 
	{
		
		int displayScenario = 99;
		
		Interface passObject = new Interface(DV);
		passObject.setVisible(true);
		//passObject.Interface(DV);
		
		
		 if(DV.gearNotDownAlarm == true && DV.gearAirSpeedAlarm == false && DV.airBrakeWarning == true && DV.gearOverrideWarning == false && DV.gearUpCommand == false)
		 {
			 displayScenario = 1;
			 
			 if(displayScenario != DV.expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(DV.gearNotDownAlarm == false && DV.gearAirSpeedAlarm == true && DV.airBrakeWarning == true && DV.gearOverrideWarning == true && DV.gearUpCommand == true)
		 {
			 displayScenario = 2;
			 if(displayScenario != DV.expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(DV.gearNotDownAlarm == true && DV.gearAirSpeedAlarm == false && DV.airBrakeWarning == false && DV.gearOverrideWarning == false && DV.gearUpCommand == false)
		 {
			 displayScenario = 3;
			 if(displayScenario != DV.expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(DV.gearNotDownAlarm == false && DV.gearAirSpeedAlarm == true && DV.airBrakeWarning == false && DV.gearOverrideWarning == true && DV.gearUpCommand == true)
		 {
			 displayScenario = 4;
			 if(displayScenario != DV.expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(DV.gearNotDownAlarm == false && DV.gearAirSpeedAlarm == true && DV.airBrakeWarning == true && DV.gearOverrideWarning == false && DV.gearUpCommand == false)
		 {
			 displayScenario = 5;
			 if(displayScenario != DV.expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(DV.gearNotDownAlarm == false && DV.gearAirSpeedAlarm == true && DV.airBrakeWarning == false && DV.gearOverrideWarning == false && DV.gearUpCommand == false)
		 {
			 displayScenario = 6;
			 if(displayScenario != DV.expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(DV.gearNotDownAlarm == false && DV.gearAirSpeedAlarm == false && DV.airBrakeWarning == true && DV.gearOverrideWarning == false && DV.gearUpCommand == false)
		 {
			 displayScenario = 7;
			 if(displayScenario != DV.expectedScenario)
			 {
				 System.out.println("Output Scenario is different than expected!");
				 totalFailedOutput++;
			 }
		 }
		 else if(DV.gearNotDownAlarm == false && DV.gearAirSpeedAlarm == false && DV.airBrakeWarning == false && DV.gearOverrideWarning == false && DV.gearUpCommand == false)
		 {
			 displayScenario = 8;
			 if(displayScenario != DV.expectedScenario)
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