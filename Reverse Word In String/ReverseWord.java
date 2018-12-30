/*
  Prompt: Reverse the order of the words in the array.
  Given Array: ['p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e']
                
  Result Array: ['p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'e', 'r', 'f',  'e', 'c', 't']   
*/

import java.util.*;
import java.io.*;

public class ReverseWord{

   public static void main(String[] args) {
      char[] input = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                      'm', 'a', 'k', 'e', 's', ' ',
                      'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
      char[] inputEven = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                      'm', 'e', ' ',
                      'm', 'a', 'k', 'e', 's', ' ',
                      'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};                
      char[] small = {'a', ' ', 'b', ' ', 'c'};
      System.out.println(reverseArray(input));
      System.out.println(reverseArrayCheat(inputEven));
      System.out.println(reverseString("perfect makes practice"));
   }
   
   //This goal is to implement this method. This version works but I am not sure if there is a more
   //efficient way to do this without using Strings or a temp value.
   public static char[] reverseArray(char[] arr){
      String temp = "";
      String word = "";
      for ( int i = 0; i < arr.length; i++) {
         if(arr[i] == ' ') {
            temp = word +" "+ temp;
            word = "";
         } else {
            word += arr[i];
         }
      }
      temp = word +" "+ temp;
      for(int i = 0; i < arr.length; i++) {
         arr[i] = temp.charAt(i);
      }
      return arr;
   }
   
   //This is a cheat version of the method that turns the array into a string then applies the method below
   public static char[] reverseArrayCheat(char[] arr) {
      String str = "";
      for (int i = 0; i < arr.length; i++) {
         str += arr[i] + "";
      }
      str = reverseString(str);
      for (int i = 0; i < arr.length; i++) {
         arr[i] = str.charAt(i);
      }
      return arr;
   }
   
   //This is a string version of the method
   public static String reverseString(String str) {
      String temp = "";
      String word = "";
      for ( int i = 0; i < str.length(); i++) {
         if(str.charAt(i) == ' ') {
            temp = word +" "+ temp;
            word = "";
         } else {
            word += str.charAt(i);
         }
      }
      temp = word +" "+ temp;
      return temp;
   }
}