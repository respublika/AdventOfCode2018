package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LetterCount {
	
	public static void main(String[] args) throws IOException {

		File file = new File("D://programozas//AdventOfCode//AdventOfCode2018//AOC2018//src//day2//input.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file));  
		  
		  List<String> inputStrings = new ArrayList<>();
		  
		  String st; 
		  while ((st = br.readLine()) != null) {
				  inputStrings.add(st);
		  } 
		  
		  Integer lettersTwice = 0;
		  Integer lettersThreeTimes = 0;
		 
		  for(int i=0; i<inputStrings.size(); i++){
			  lettersTwice +=  countLettersTimes(inputStrings.get(i), 2);
			  lettersThreeTimes +=  countLettersTimes(inputStrings.get(i), 3);
         }
		  
		  System.out.println(lettersTwice*lettersThreeTimes);

		  
	}
	
	public static List<Character> uniqueCharacters(String string) {
		List<Character> uniqueList = new ArrayList<>();
		for(int i=0; i<string.length(); i++){
			if (!uniqueList.contains(string.charAt(i))) {
				uniqueList.add(string.charAt(i));
			}
		}
	
		return uniqueList;
	}
	
	public static Integer countLettersTimes(String string, Integer times) {
		Integer countTimes = 0;
		List<Character> uniqueLetters = uniqueCharacters(string);

		 for(int i=0; i<uniqueLetters.size(); i++){
			 Integer charTimes = 0;
			 for(int j=0; j<string.length(); j++){
				  if (uniqueLetters.get(i)==string.charAt(j)) {					  
					  charTimes++;
				  }
	         }
			  
			  if (charTimes==times) {
				  countTimes++; 
			  }   
			 
         }	  
		 if (countTimes>0) {
			 countTimes=1;
		 }
		  return countTimes;
		  
	}


}
