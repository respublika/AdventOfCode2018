package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckId {
	
	public static void main(String[] args) throws IOException {

		File file = new File("D://programozas//AdventOfCode//AdventOfCode2018//AOC2018//src//day2//input.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file));  
		  
		  List<String> inputStrings = new ArrayList<>();
		  
		  String st; 
		  while ((st = br.readLine()) != null) {
				  inputStrings.add(st);
		  } 
		  
		 
		  for(int i=0; i<inputStrings.size(); i++){
			  for(int j=0; j<inputStrings.size(); j++){
				  if (checkIdDifference(inputStrings.get(i), inputStrings.get(j))<=1
						  && inputStrings.get(i)!=inputStrings.get(j)) {
					  System.out.println(getCommonLetters(inputStrings.get(i), inputStrings.get(j)));
				  }
			  }

         }
		  
	}
	
	
	public static Integer checkIdDifference(String string1, String string2) {
		Integer difference = 0;
		 for(int i=0; i<string1.length(); i++){
			 if (string1.charAt(i)!=string2.charAt(i)) {
				 difference++;
			 }
		 }
			 
		  return difference;
		  
	}
	
	public static String getCommonLetters(String string1, String string2) {
		String commonLetters = new String();
		 for(int i=0; i<string1.length(); i++){
			 if (string1.charAt(i)==string2.charAt(i)) {
				 commonLetters+=Character.toString(string1.charAt(i));

			 }
		 }
			 
		  return commonLetters;
		  
	}

}
