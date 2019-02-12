package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FabricCut {
	
	public static void main(String[] args) throws IOException {

		File file = new File("D://programozas//AdventOfCode//AdventOfCode2018//AOC2018//src//day3//input.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file));  
		  
		  List<Claim> inputStrings = new ArrayList<>();
		  
		  String st; 
		  while ((st = br.readLine()) != null) {
			  Integer start1 = st.indexOf('@')+2;
			  Integer end1 = st.indexOf(',');
			  Integer start2 = st.indexOf(',')+1;
			  Integer end2 = st.indexOf(':');
			  Integer start3 = st.indexOf(':')+2;
			  Integer end3 = st.indexOf('x');
			  Integer start4 = st.indexOf('x')+1;
			  Integer end4 = st.length();
			  
			  inputStrings.add(new Claim(Integer.parseInt(st.substring(start1, end1)), 
					  Integer.parseInt(st.substring(start2, end2)), Integer.parseInt(st.substring(start3, end3)),
					  Integer.parseInt(st.substring(start4, end4))));
		  }
		  
		  List<String> fabric = createBaseFabric();
		  
		
		  for(Claim claim : inputStrings) {
			  modifyFabric(fabric, claim);
		  }
		  
		  Integer result=0;
		  for(String str : fabric) {
			  result+=characterCount(str, 'X');
		  }
		  
		  System.out.println(result);
		  
		  Integer uniqueClaimId=null;
		  for(Claim claim : inputStrings) {
			  if (checkUniqueClaim(fabric, claim)) {
				  uniqueClaimId=inputStrings.indexOf(claim)+1;
				  System.out.println(uniqueClaimId);
			  }
		  }
	}
	
	public static List<String> createBaseFabric() {
		List<String> baseFabric = new ArrayList<>();
		for(int i=0; i<1000; i++){
			baseFabric.add(createStringChain(1000, "."));			
		}
	
		return baseFabric;
	}
	
	public static String createStringChain(Integer number, String string) {
		String str=string;
		for(int i=1; i<number; i++){
			str+=string;	
		}
		return str;
		
	}
	
	public static String createModifiedStringSlice(String string) {
		String str="A";
		for(int i=0; i<string.length(); i++){
			if (string.charAt(i)=='.') {
				str+="*";
			} else {
				str+="X";
			} 
		}
		return str.substring(1);
		
	}
	
	public static Integer characterCount(String str, Character toCount) {
		Integer count=0;
		for(int i=0; i<str.length(); i++){
			if (str.charAt(i)==toCount) {
				count++;			
			}
		}
		return count;
	}
	
	public static void modifyFabric(List<String> fabric, Claim claim) {	
		for(int i=0; i<claim.getToDown(); i++){	
			String replace=createModifiedStringSlice(fabric.get(claim.getDown()+i).substring(claim.getLeft(), claim.getLeft()+claim.getToLeft()));
			String toReplace = fabric.get(claim.getDown()+i).substring(0, claim.getLeft()) + replace + 
					fabric.get(claim.getDown()+i).substring(claim.getLeft()+claim.getToLeft(), fabric.get(claim.getDown()+i).length());
			fabric.set(claim.getDown()+i, toReplace);	
		}
	}
	
	public static Boolean checkUniqueClaim(List<String> fabric, Claim claim) {
        Boolean uniqueClaim=true;
        Integer countChar=0;   
        for(int i=0; i<claim.getToDown(); i++){
            countChar+=characterCount(fabric.get(claim.getDown()+i).substring(claim.getLeft(), claim.getLeft()+claim.getToLeft()), 'X');                              
        }
        if (countChar>0) {
            uniqueClaim=false;       
        }
        return uniqueClaim;
}

}
