package week4;

import java.util.Scanner;

public class CrossCountry{
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      processRunner(in);
      processRunner(in);
      processRunner(in);
      in.close();
   }

 /**
  * Method processRunner - 
  * Takes the inputs from keyboard through the Scanner and outputs the results 
  */
   private static void processRunner(Scanner in) {
      String firstName, lastName;
      String mileOne, mileTwo, finishTime;
      String splitTwo, splitThree;

      /**
       * Gets the user inputs for their first and last name, time for mileOne, time for mileTwo and time for mileThree
       */

       System.out.println("Enter your first name: "); 
       firstName = in.nextLine();  
       System.out.println("Enter last name: "); 
       lastName = in.nextLine(); 
       System.out.println("Enter mile one: "); 
       mileOne = in.nextLine(); 
       System.out.println("Enter mile two: "); 
       mileTwo = in.nextLine(); 
       System.out.println("Enter finish time: "); 
       finishTime = in.nextLine(); 

      splitTwo = subtractTimes(mileTwo, mileOne);
      splitThree = subtractTimes(finishTime, mileTwo);

      /**
       * Displays a summary for the user of there times for each of the splits
       */

       System.out.println(firstName + " " + lastName); 
       System.out.println("Split one: " + mileOne); 
       System.out.println("Split two: " + splitTwo); 
       System.out.println("Split three: " + splitThree); 

   }

   /**
    * Method SubtractTimes -
    * takes runner times for mileOne/mileTwo or mileTwo/mileThree strings in format (m:ss.sss) and subtracts them from one another
    * then returns the difference 
    * 
    */

   private static String subtractTimes(String endTime, String startTime) {
      double endInSeconds = convertToSeconds(endTime);
      double startInSeconds = convertToSeconds(startTime);

      double diffInSeconds = endInSeconds - startInSeconds;

      return convertToTime(diffInSeconds);
   }

   /**
    * 
    * Method convertToTime -
    * takes diffInSeconds double and returns it in the format m:ss.sss
    * 
    *
    */

   private static String convertToTime(double diffInSeconds) {
       return String.format("%d:%06.3f", getMinutes(diffInSeconds), getSeconds(diffInSeconds));

      
   }

   /**
    * 
    * Method getMinutes -
    * Changes the seconds double into minutes 
    * returns it so Method convertTotime can create the final format
    */

   public static int getMinutes(Double seconds){
    int minutes = (int)(seconds/60);
    return minutes;

   }

   /**
    * 
    * Method getSeconds -
    * gets the remainder of seconds after getting minutes
    * returns it so Method convertToTime can create the final format 
    */

   private static double getSeconds(Double seconds){
    double seconds1 = (seconds%60);
    return seconds1;
   }

   /**
    * 
    * Method convertToSeconds -
    * Takes the string inputed by the user (ex: 5:03.222), removes the colon and then turns the string into a double.
    * Then converts minutes into seconds and returns it in new format
    * ie. format m:ss.sss -> format sss.sss
    */
   

   private static double convertToSeconds(String endTime) {
      int colonLocation = endTime.indexOf(":");
      double minutes = Double.valueOf(endTime.substring(0,colonLocation));
      double seconds = Double.valueOf(endTime.substring(colonLocation + 1));
      return ((minutes*60) + seconds);

  

   }



}