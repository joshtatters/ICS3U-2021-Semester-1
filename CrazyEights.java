package week4;

import java.util.Scanner;

public class CrazyEights{
   private static String p1 = "";
   private static String c1 = "";
   private static String c2 = "";
   private static String topCard = "";



   private static final int NUM_SUITS = 4;
   private static final String HEARTS = "H";
   private static final String DIAMONDS = "D";
   private static final String CLUBS = "C";
   private static final String SPADES = "S";
   private static final double CARDS_PER_SUIT = 13;
   private static final String ACE = "A";
   private static final String JACK = "J";
   private static final String QUEEN = "Q";
   private static final String KING = "K";

   public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int p1Points = 0, c1Points = 0, c2Points = 0;

    p1 = dealCards();
    c1 = dealCards();
    c2 = dealCards();

    topCard = getCard("");
   
    System.out.println("Welcome to Crazy Eights!");
    // overall match
    // individual rounds
    
   // loop that checks score 
   // individual rounds of games

   

   while (!gameOver(p1Points, c1Points, c2Points)) {
      String result = playRound(in);
      System.out.println(p1);
      int firstDash = result.indexOf("-");
      int secondDash = result.indexOf("-", firstDash + 1);
      p1Points += Integer.parseInt(result.substring(0, firstDash));
      c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
      c2Points += Integer.parseInt(result.substring(secondDash + 1));

      

      System.out.println("Current Score: " + p1Points + " " + c1Points + " " + c2Points);
   
   }
  
    
   }

   
   private static String showPlayer() { 
      return "";
   }


      private static String dealCards() {
         // deal 5 cards
         // return string of 5 cards
         String playerHand = "";
         for (int i = 0; i < 5; i++){
            playerHand += getCard(playerHand) + " ";
         }
         return playerHand; 
    }

    
    private static String getCard(String usedCards) {
            String card = getFace() + getSuit();
      
            while (usedCards.indexOf(card) >= 0) {
               card = getFace() + getSuit();
            }
            return card;
            //TODO implement used cards
         }
      
         private static String getSuit() {
            int suit = (int) (Math.random() * NUM_SUITS);
      
            if (suit == 0)
               return HEARTS;
            else if (suit == 1)
               return DIAMONDS;
            else if (suit == 2)
               return CLUBS;
            else
               return SPADES;
      
         }
      
         private static String getFace() {
            int suit = (int) (Math.random() * CARDS_PER_SUIT);
            if (suit >= 2 && suit <= 10)
               return suit + "";
            else if (suit == 1)
               return ACE;
            else if (suit == 11)
               return JACK;
            else if (suit == 12)
               return QUEEN;
            else
               return KING;
      
         }        

    private static void deck() {
    }


      private static String playRound(Scanner in) {
         // loop for start of each round
         

         System.out.println("This is your hand: " + p1);
         System.out.println("This is the card your playing on: " + topCard);
         System.out.println("Choose what card your going to play: ");
         
         String pickCard = in.nextLine(); 
         // fact check card (make sure you have card in hand)
         
         String newHand = p1.substring(0, p1.indexOf(pickCard)) + p1.substring(p1.indexOf(pickCard) + pickCard.length());
         p1 = newHand;

         topCard = pickCard; 
         
   
         return "37-0-12";
      }
   
      private static String processComputer(int e, boolean isLastCard, int yesEight) {
         String temp = topCard;
         String tempHand = "";
         
         if(e == 1){
            tempHand= c1;

         }else{
            tempHand = c2;
         }
        int suitLocation = hasSuit(tempHand, temp);
        int faceLocation = hasFace(tempHand, temp);
        
         if(yesEight != 0 && isLastCard){
         // places 8
         // removes 8 from hand
         // picks suit based on one in hand
         // passes suit (H, C, D, S)

            String isEightStr = isEight( tempHand,  temp); 
            String diffSuits = "HCDS";
            for (int i = 0; i < 4; i++){
               // temphand after you played your 8, makesure that 8 is gone first
               int response = hasSuit(tempHand, diffSuits.substring(i,i+1));  // uses hasSuit method and reads through diffSuits 
               // to see if they match one in hand
               if(response != 0){
                     temp = "8" + diffSuits.substring(i, i+1) + " ";           
                  // change topcard suit 
                  // temp = topcard face suit space
                  // take suit & 158, change temp second char to equal 
                  // temp = "8" + diffsuits substring(i,i+1)
               }
               
            }
            return temp;
         }

     /*    if(suitLocation != 0){
            String cardPlayed = tempHand.substring(( -1)*3, *3); // suitlocation = 1 - 1*3 = 0      
            topCard = cardPlayed; */

         if(suitLocation != 0){
            String cardPlayed = tempHand.substring((suitLocation-1)*3,suitLocation*3); // suitlocation = 1 - 1*3 = 0      
            topCard = cardPlayed; 
            // removes card from hand
            String newHand = tempHand.substring(0, tempHand.indexOf(cardPlayed)) + tempHand.substring(tempHand.indexOf(cardPlayed)+3);
            return newHand; 
         }else if(faceLocation !=0){
            String cardPlayed = tempHand.substring((faceLocation-1)*3,faceLocation*3);  
            topCard = cardPlayed; 
            String newHand = tempHand.substring(0, tempHand.indexOf(cardPlayed)) + tempHand.substring(tempHand.indexOf(cardPlayed)+3);
            return newHand; 
         }

         return "";

      }
      private static String isEight(String tempHand, String temp) {
         return null;
      }


      private static boolean LastCard(String tempHand, String temp){
         // this method checks if the computer is on their last card 
         //TODO need to tweak it so it works for player hand aswell
         boolean isLastCard = false;
         
         if (tempHand.length() <= 3){
            isLastCard = true;
         }
         return isLastCard;
   }
      private static int checkForEight(String tempHand, String temp){
         // this method checks if the computer hand has an 8 
         //TODO need to tweak for player 
         int yesEight = 0;
         for(int i = 0; i < tempHand.length(); i++){
            String count = tempHand.substring(i, i+1);
            if(count.equals("8"))
               yesEight = i;
      }
      return yesEight;
   }

      private static int findEight(String tempHand, String temp){
         int checkEight = tempHand.indexOf("8"); //finds index of 8 in hand
         // find if location is 0 3 6 9 12
         return checkEight/3; //needs to be tested 0/3 could act up
         
         }

         private static int hasSuit(String tempHand, String suit){
            // checks if there is a suit that matches topcard
            // returns card location or 0 if no card found 
         for (int i = 0; i < tempHand.length()/3; i++){
            // divides by three because 3 characters per card (Face Suit Space "7H ")
            String foundSuit = tempHand.substring(i+1,i+2);
            // gets suit
            if (foundSuit.equals(suit)){
            return i+1;
            }
            }
            return 0; // has no card 

         }

   /*      private static int hasSuit(String tempHand, String temp){
            // checks if there is a suit that matches topcard
            // returns card location or 0 if no card found 
         String suit = temp.substring(temp.length()-1).trim();
         for (int i = 0; i < tempHand.length()/3; i++){
            // divides by three because 3 characters per card (Face Suit Space "7H ")
            String foundSuit = tempHand.substring(i+1,i+2);
            // gets suit
            if (foundSuit.equals(suit)){
            return i+1;
            }
            }
            return 0; // has no card 

         } */

         private static int hasFace(String tempHand, String temp){
            String face = temp.substring(0,1);
            for (int i = 0; i < tempHand.length()/3; i++){
               // divides by three because 3 characters per card (Face Suit Space "7H ")
               String foundface = tempHand.substring(i+1,i+2);
               // gets suit
               if (foundface.equals(face)){
               return i+1;
               }
               }
               return 0; // has no card 
   
            }

         


 
      private static String processPlayer(String playerHand, String topCard) {

         return "7H 3D 4C-2D";
      }
   
      private static boolean gameOver(int p1Points, int c1Points, int c2Points) {
         return p1Points >= 100 || c1Points >= 100 || c2Points >= 100;
      }

   }
   
   

     
   