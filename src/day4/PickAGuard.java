package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import day3.Claim;

public class PickAGuard {
	public static void main(String[] args) throws IOException {

		File file = new File("D://programozas//AdventOfCode//AdventOfCode2018//AdventOfCode2018//src//day4//input.txt");
		  
		  BufferedReader br = new BufferedReader(new FileReader(file));  
		  
		  List<String> inputStrings = new ArrayList<>();
		  
		  String st; 
		  while ((st = br.readLine()) != null) {
			  inputStrings.add(st);
		  }
		  
		  Collections.sort(inputStrings);
		  
		  List<NightActivity> inputActivities = createActivities(inputStrings);
		  
		  List<Guard> guardList=createMaxGuardSleep(inputActivities);
		    
	}
	
	public static List<Guard> createMaxGuardSleep(List<NightActivity> inputActivities) {
		List<Guard> guardList = new ArrayList<>();
		
		return guardList;
	}
	
	public static List<NightActivity> createActivities(List<String> inputStrings) {
		List<NightActivity> inputActivities = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentGuard=null;
		LocalDateTime currentDate=null;
		Boolean currentSleep=null;
		LocalDateTime nextDate = null;
		for(int i=0; i<inputStrings.size(); i++) {
		  if (i<inputStrings.size()-1) {
			    if (inputStrings.get(i).substring(19, 24).equals("Guard")) {
			    	currentGuard=inputStrings.get(i).substring(inputStrings.get(i).indexOf("#")+1, 
					  inputStrings.get(i).indexOf("#")+inputStrings.get(i)
							  .substring(inputStrings.get(i).indexOf("#")).indexOf(" "));
					currentSleep=false;
				} else if (inputStrings.get(i).substring(19, 24).equals("falls")) {
					currentSleep=true;
				} else if (inputStrings.get(i).substring(19, 24).equals("wakes")) {
					currentSleep=false;
				} else {
					System.out.println("What?");
				}
				currentDate=LocalDateTime.parse(inputStrings.get(i).substring(1, 17)+":00", formatter);
			    nextDate=LocalDateTime.parse(inputStrings.get(i+1).substring(1, 17)+":00", formatter);
			  if (currentDate.getHour()<1) {
				  inputActivities.add(new NightActivity(currentDate, currentGuard, currentSleep));
			  }
				while (currentDate.plusMinutes(1).isBefore(nextDate)
						&& ((currentDate.getHour()<1 && currentDate.getMinute()<59) || currentDate.getHour()==23)) {
					currentDate=currentDate.plusMinutes(1);
					if (currentDate.getHour()<1) {
						inputActivities.add(new NightActivity(currentDate, currentGuard, currentSleep));
					} else {
						continue;
					}

				}
			} else if (i==inputStrings.size()-1) { 
				String inputString=inputStrings.get(inputStrings.size()-1);
				currentDate=LocalDateTime.parse(inputString.substring(1, 17)+":00", formatter);
				if (inputString.substring(19, 24).equals("Guard")) {
				   currentGuard=inputString.substring(inputString.indexOf("#")+1, 
				    	inputString.indexOf("#")+inputString.substring(inputString.indexOf("#")).indexOf(" "));
				   currentSleep=false;
				} else if (inputString.substring(19, 24).equals("falls")) {
					currentSleep=true;
				} else if (inputString.substring(19, 24).equals("wakes")) {
					currentSleep=false;						
				} else {
					System.out.println("What?");
				}
				inputActivities.add(new NightActivity(currentDate, currentGuard, currentSleep));
			  	while (currentDate.getHour()<1) {
				  currentDate=currentDate.plusMinutes(1);
				  inputActivities.add(new NightActivity(currentDate, currentGuard, currentSleep));
			  	}
			  } else {
					System.out.println("What?");
			  }	
		  }
		return inputActivities;

	}
	
}
