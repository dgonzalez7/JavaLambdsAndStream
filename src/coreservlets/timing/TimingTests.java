package coreservlets.timing;

import java.util.*;

public class TimingTests 
{
  public static void main(String[] args) 
  {
    for(int i=3; i<8; i++) 
    {
      int size = (int)Math.pow(10, i);
      
      Op2 sortArray = () -> sortArray(size);
      Op2 wasteTime = () -> wasteTime(size);
      Op2 doBoth = sortArray.combinedOp2(wasteTime);
      
      System.out.printf("Sorting array of length %,d.%n", size);
      // TimingUtils.timeOp( () -> sortArray(size) );
      Op2.timeOp2(sortArray);
      
      System.out.printf("Wasting time (%,d repeats).%n", size);
      // TimingUtils.timeOp( () -> sortArray(size) );
      // Op2.timeOp2( () -> sortArray(size) );
      Op2.timeOp2(wasteTime);
      
      System.out.printf("Doing both (%,d repeats).%n", size);
      Op2.timeOp2(doBoth);
      
    }
  }
  
  /** Make an n-length array of random numbers. */
  
  public static double[] randomNums(int length) 
  {
    double[] nums = new double[length];
    for(int i=0; i<length; i++) 
    {
      nums[i] = Math.random();
    }
    return(nums);
  }
  
  public static void sortArray(int length) 
  {
    double[] nums = randomNums(length);
    Arrays.sort(nums);
  }
  
  public static void wasteTime(int length) 
  {
    double[] nums = randomNums(length);
    Arrays.sort(nums);
  }
}
