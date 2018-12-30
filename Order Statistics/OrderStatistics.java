import java.util.*;
/*
  1 6 3 9 8 5 
  0th smallest = 1
  1st smallest = 3
  mth smallest = mth index after being sorted
*/
import java.io.*;

public class OrderStatistics {

   public static void main(String[] args) {
      int[] input = {10,2,5,6,11,3,15,1,12,13,17,20,7};
      System.out.println(smallest(input));
      System.out.println(secondSmallest(input));
      System.out.println(mth(input,6));
   }
   
   //returns the smallest number in the list.
   public static int smallest(int[] list) {
      int min = Integer.MAX_VALUE;
      for( int i = 0; i < list.length; i++) {
         if(min > list[i])
            min = list[i];
      }
      return min;
   }

   //returns the second smallest in the list.
   public static int secondSmallest(int[] list) {
      int min = Integer.MAX_VALUE;
      int min2 = Integer.MAX_VALUE;
   
      for(int i = 0; i < list.length; i++) {
         if(min > list[i]){
            min2 = min;
            min = list[i];
         }else if (min2 > list[i]){
            min2 = list[i];
         }
      }
      return min2;
   }
   
   //returns the mth smallest number.
   public static int mth(int[] list, int m){
      int[] arr = new int[list.length];
      int start = 0;
      int end =list.length-1;
      int index = 0; 
      int og = list[0];
      for (int i = 1; i < list.length; i++) {
         if(list[index] > list[i]) {
            arr[start] = list[i];
            start++;  
         } else{
            arr[end] = list[i];
            end--;
         }
      }
      arr[start] = og;
      list = arr;
      if (m > start) 
         return mth(Arrays.copyOfRange(list,start+1, list.length), m-start-1);
      else if(m < start)
         return mth(Arrays.copyOfRange(list, 0, start), m);
      return list[m];
   }
   
}