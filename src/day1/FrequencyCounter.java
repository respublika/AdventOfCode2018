package day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List; 


public class FrequencyCounter {
	
	public static void main(String[] args) throws IOException {

		File file = new File("D://programozas//AdventOfCode//AdventOfCode2018//AOC2018//src//day1//input_day1_frequency.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file));  
		  
		  List<Integer> inputNumbers = new ArrayList<>();
		  
		  String st; 
		  while ((st = br.readLine()) != null) {
			  if (st.startsWith("+")) {
				  Integer st2 = Integer.parseInt(st.substring(1));
				  inputNumbers.add(st2);
			  } else {
				  Integer st2 = Integer.parseInt(st);
				  inputNumbers.add(st2);
			  }
		  } 
		  
		  System.out.println(countFrequency(inputNumbers));
		  System.out.println(countFrequencyValueTwice(inputNumbers));
		  
	}
	
	public static Integer countFrequency(List<Integer> list) {
		Integer start = 0;

		  for(int i=0; i<list.size(); i++){
			  start = start + list.get(i);
         }
		  
		  return start;
		  
	}
	
	public static Integer countFrequencyValueTwice(List<Integer> list) {
		Integer start = 0;
		List<Integer> twiceList = new ArrayList<>();
		List<Integer> currentList = new ArrayList<>();
		
		while (twiceList.isEmpty()) {
		  for(int i=0; i<list.size(); i++) {
			  currentList.add(start);
			  start = start + list.get(i);
			  if (currentList.contains(start)) {
				  twiceList.add(start);
			  }
		  }
		}
		 
		  return twiceList.get(0);

	}

}
