/*Prompt:
  Write a function that takes two strings, str1 and str2 and 
  returns the logest common subsequence of str1 and str2
  
  "ABAZDC", "BACBAD" => "ABAD"
  "AGGTAB", "GXTXAYB" => "GTAB"
  "aaaa", "aa" => "aa"
  "", "..." => ""
  
*/  

import java.util.*;

public class CommonSubsequence{

   public static void main(String[] args) {
      String str1 = "ABBA";
      String str2 = "ABCABA";
      System.out.println(findCommonSubsequence(str1,str2));
   }
   
   
   //Initial solution using recursion. Time: 36 min
   public static String findCommonSubsequence(String str1, String str2) {
      
      if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
         return "";
      }
      
      ArrayList<String> potentials = new ArrayList<String>();
      int greatestLen = -1;
      int greatestIndex = 1;
      
      for (int i = 0; i < str1.length(); i++) {
         int pos = str2.indexOf(str1.substring(i, i+1));
         if (pos != -1) {
            potentials.add(str1.substring(i,i+1) + findCommonSubsequence(str1.substring(i+1),str2.substring(pos+1)));
         
          
            if (greatestLen < potentials.get(i).length()) {
               greatestLen = potentials.get(i).length();
               greatestIndex = i;
            }
         } else {
            potentials.add("");
         }
         
      }
      
      
      return potentials.get(greatestIndex);
   }  

}