import java.util.Scanner;
import java.util.Random; 
/*Name: Amanda, Emily, Jasmine, and Tina
 * Date: 23 April 2018
 * Teacher: Mr Chu
 * Description: A game of bowling
 */

public class BowlingFinal {
 public static void main (String args[]) {
  
  //variable declaration and initialization
  
  Scanner input = new Scanner(System.in);
  String [] pins = {"1","2","3","4","5","6","7","8","9","10"} ;
  String [] name = {" ","Computer User"} ;
  String bumper ;
  String answerAim= "" ;
  int turn = 1 ;
  int count = 0 ;
  int amountHit = 0 ; 
  int tries = 0 ;
  int points = 0 ;
  boolean knockedDown = false ;
  int [] pointsTotalUser = new int [10];
  int [] pointsTotalComp = new int [10] ;
  int pointsFrameUser = 0 ;
  int pointsFrameComp = 0 ;   
  int totalUserScore = 0 ;
  int  totalCompScore = 0;

  System.out.println ("Enter a username: ") ; //prompt user to enter a username
  name [0] = input.nextLine () ;

  System.out.println ("Hello " + name [0] + ", welcome to Bowling!") ; //welcomes user to the game of bowling
  System.out.println ("You are playing against " + name [1]) ;
  System.out.println (" ") ;

  do { //asks user if they would like to use bumpers or not
   System.out.println ("Would you like to use bumpers? (y/n)") ;
   bumper = input.nextLine() ;

   if (!bumper.equals ("y") && !bumper.equals ("n")){ //user validation for bumper input
    System.out.println ("You did not enter 'y' or 'n'") ;
   }
  }while (!bumper.equals ("y") && !bumper.equals ("n")) ;

  for (int i=1 ; i<=20 ; i++) {//game that runs for 10 frames
   

   bowlingPlay (turn, bumper, pins, tries, name, answerAim, knockedDown, count, amountHit, points, pointsTotalUser, pointsTotalComp, pointsFrameUser, pointsFrameComp, totalUserScore, totalCompScore) ;//call for bowling game method

   turn ++ ; //check whose turn it is

   if (turn%2 == 1) {//+1 for every frame
    count ++ ;
   }
  }
  input.close();
 }

 public static void bowlingPins (int amountHit, String [] pins) { //bowling pin method
  int num = 0 ; //variable declaration and initialization 

  for (int i=1; i<5; i ++ )//spacing to make pins in the middle
  {
   for (int k=0; k < (6 - i); k++)//outputs the shape of a triangle
   {
    System.out.print(" ");
   }
   for (int j=0; j<i; j++)
   {
    System.out.print(pins [num] + " ");
    num ++ ;
   }
   System.out.println("");

  }
  return ;//return back to main method
 }

 public static String [] bowlingPlay (int turn, String bumper, String [] pins, int tries, String [] name, String answerAim, boolean knockedDown, int count, int amountHit, int points, int [] pointsTotalUser, int [] pointsTotalComp, int pointsFrameUser, int pointsFrameComp, int totalUserScore, int totalCompScore) {
  //variable declaration and initialization 
  String key ;
  int computerAim ;
  Random random = new Random(); //random object
  Scanner input = new Scanner(System.in);
  int pinsHit = 0 ;

  do {//only runs if all pins are not knocked down in the first try

   if (turn%2 == 1) { //user's turn
    do {
     System.out.println ("Would you like to aim left (1), right (2), or centre (3)? ");
     answerAim = input.nextLine();

     if ((!answerAim.equals ("1")) && (!answerAim.equals ("2")) && (!answerAim.equals ("3"))) {//output message if user did not enter 1,2,3
      System.out.println ("You did not enter 1, 2 or 3") ;
     }
    }while (!answerAim.equals ("1") && !answerAim.equals ("2") && !answerAim.equals ("3")) ;//check if user entered 1,2,3

    System.out.println (name [0] + "'s turn") ; 

    System.out.println ("Enter any key to bowl") ;
    key = input.nextLine () ;//input

   }
   else if (turn%2 == 0) {
    System.out.println (name [1] + "'s turn") ;//comp's turn

    computerAim = random.nextInt (3) +1 ;//randomize computer's aim

    answerAim = Integer.toString(computerAim); //convert int to string
   }

   if (bumper.equals ("y")) {//use bumpers
        amountHit = random.nextInt (10) + 1  ;//random generator from 1-10        
      }
      else if (bumper.equals("n")){// does not use bumpers
        amountHit = random.nextInt (10 + 1)  ; //random generator from 0-10
      }

   pinsHit = random.nextInt (100) +1 ;//randomizes left or right hit

   //knockes down pins
   if ((amountHit == 1)||(amountHit == 2) || (amountHit == 3) || (amountHit == 4) || (amountHit == 5) || (amountHit == 6) || (amountHit == 7) || (amountHit == 8) || (amountHit == 9))  {//randomizes which pin will be knocked down    

    if (answerAim.equals ("1") && pinsHit <= 60) { //if user aims to the left, 60% hits left pin
     pins [6] = "X" ;
    } else if (answerAim.equals ("1") && pinsHit > 60){ //40% hits right pin
     pins [9] = "X";
    }

    if (answerAim.equals ("2") && pinsHit <= 60){ //if user aims to the right, 60% hits right pin
     pins [9] = "X" ;
    } else if (answerAim.equals ("2") && pinsHit > 60) //40% hits left pin
     pins [6] = "X";
   }

   if ((amountHit == 2) || (amountHit == 3) || (amountHit == 4) || (amountHit == 5) || (amountHit == 6) || (amountHit == 7) || (amountHit == 8) || (amountHit == 9)) {
    if (answerAim.equals ("1") && pinsHit <= 60) { //if user aims to the left, 60% hits left pin
     pins [3] = "X" ;
    } else if (answerAim.equals ("1") && pinsHit > 60){ //40% hits right pin
     pins [5] = "X";
    }

    if (answerAim.equals ("2") && pinsHit <= 60){ //if user aims to the right, 60% hits right pin
     pins [5] = "X" ;
    } else if (answerAim.equals ("2")&& pinsHit > 60) //40% hits left pin
     pins [3] = "X";
   }

   if ((amountHit == 3) || (amountHit == 4) || (amountHit == 5) || (amountHit == 6) || (amountHit == 7) || (amountHit == 8) || (amountHit == 9)) {
    if (answerAim.equals ("1") && pinsHit <= 60) { //if user aims to the left, 60% hits left pin
     pins [7] = "X" ;
    } else if (answerAim.equals ("1") && pinsHit > 60){ //40% hits right pin
     pins [8] = "X";
    }

    if (answerAim.equals ("2") && pinsHit <= 60){ //if user aims to the right, 60% hits right pin
     pins [8] = "X" ;
    } else if (answerAim.equals ("2") && pinsHit > 60) {//40% hits left pin
     pins [7] = "X";
    }
   }

   if ((amountHit == 4) || (amountHit == 5) || (amountHit == 6) || (amountHit == 7) || (amountHit == 8) || (amountHit == 9)) {
    if (answerAim.equals ("1") && pinsHit <= 60) { //if user aims to the left, 60% hits left pin
     pins [1] = "X" ;
    } else if (answerAim.equals ("1") && pinsHit > 60){ //40% hits right pin
     pins [2] = "X";
    }

    if (answerAim.equals ("2") && pinsHit <= 60){ //if user aims to the right, 60% hits right pin
     pins [2] = "X" ;
    } else if (answerAim.equals ("2") && pinsHit > 60) //40% hits left pin
     pins [1] = "X";
   }

   if ((amountHit == 5) || (amountHit == 6) || (amountHit == 7) || (amountHit == 8) || (amountHit == 9)) {
    pins [4] = "X" ;
   }

   if ((amountHit == 6) || (amountHit == 7) || (amountHit == 8) || (amountHit == 9)) {
    pins [0] = "X" ;
   }

   if ((amountHit == 7) || (amountHit == 8) || (amountHit == 9)) {
    if (pinsHit <= 50) {//left
     pins [2] = "X" ;
    }
    else {//right
     pins [1] = "X" ;
    }
   }

   if ((amountHit == 8) || (amountHit == 9)) {
    if (pinsHit <= 50) {//left
     pins [8] = "X" ;
    }
    else {//right
     pins [7] = "X" ;
    }
   }

   if (amountHit == 9) {
    if (pinsHit <= 50) {//left
     pins [5] = "X" ;
    }
    else { //right
     pins [3] = "X" ;
    }
   }

   //knocking down center pins
   if ((amountHit == 6 ||amountHit == 8 )&& answerAim.equals ("3")) {
    pins [0] = "X" ;
    pins [1] = "X" ;
    pins [2] = "X" ;
    pins [4] = "X" ;
    pins [7] = "X" ;
    pins [8] = "X" ;
   }
   if (amountHit == 8 && answerAim.equals ("3")) {
    pins [3] = "X" ;
    pins [5] = "X" ;
   }

   //strike
   if (amountHit == 10) {
    for (int j=0 ; j<amountHit ; j++) {
     pins [j] = "X" ; 
    }
   }

   tries++ ;//counts how many tries person rolls bowling ball for

   bowlingPins (amountHit, pins) ;//calls for outputing bowling pin method

   pointSystem (name, turn, tries, amountHit, points, count, pins, pointsTotalComp, pointsTotalUser, pointsFrameUser, pointsFrameComp, bumper, totalUserScore, totalCompScore, knockedDown) ; //calls for point system method


   //checks for reset in pins
   if (tries == 2 || amountHit == 10) {
    knockedDown = true ;

    pinsKnockedDown ( amountHit,  tries, pins, knockedDown, points) ;
   }


  }while (knockedDown == false) ;//runs while not all pins are knocked down

  return pins ;//return to main method with the amount of pins     
 }

 public static void pinsKnockedDown (int amountHit, int tries, String [] pins, boolean knockedDown, int points) {
  tries = 0 ; //variable reset
  points = 0 ;

  pins [0] = "1" ;
  pins [1] = "2" ;
  pins [2] = "3" ;
  pins [3] = "4" ;
  pins [4] = "5" ;
  pins [5] = "6" ;
  pins [6] = "7" ;
  pins [7] = "8" ;
  pins [8] = "9" ;
  pins [9] = "10" ;

  return  ; //return to bowling play method
 }



 public static void pointSystem (String [] name, int turn, int tries, int amountHit, int points, int count, String [] pins, int [] pointsTotalComp, int []pointsTotalUser, int pointsFrameUser, int pointsFrameComp, String bumper, int totalUserScore, int totalCompScore, boolean knockedDown) {

  for (int i=0 ; i<10 ; i++) {//+1 point to each frame for every pin knocked down
   if ( pins [i].equals ("X")) {
    points ++ ;
   }
  }

  //calculate extra points added for strike or spare
  if (turn%2 == 1) {//user
   if (points == 10 && tries == 1) {  // strike
    pointsFrameUser = 20 ;

   } else if (points == 10 && tries == 2){ // spare
    pointsFrameUser = 15 ;

   } else if (amountHit != 10 && tries == 2) { // points accumulated (no strike or spare)
    pointsFrameUser += points + totalUserScore ;

   }  


   pointsTotalUser [count] = pointsFrameUser  ;//adds to frame score
  }

  if (turn%2 == 0) {//comp
   if (points == 10 && tries == 1) { // strike
    pointsFrameComp = 20 ;// add 20 to points

   } else if (points == 10 && tries == 2) { // spare
    pointsFrameComp = 15 ; // add 15 to points

   } else if (amountHit != 10 && tries == 2) { //no strike or spare
    pointsFrameComp += points + totalCompScore;

   }

   pointsTotalComp [count] = pointsFrameComp  ;//adds to frame score
  }

  for ( int i=0 ; i< 10 ; i++) { // accumulate total score for user
   totalUserScore += pointsTotalUser [i];
  }

  for ( int i=0 ; i<10 ; i++) { // accumulate total score for comp
   totalCompScore += pointsTotalComp [i];
  }
  //point system output for user
  if ((turn%2 == 1 && tries == 2 )|| (turn%2 == 1 && tries == 1 && pointsFrameUser == 20)) {//user
   System.out.println (name [0] + " :") ;
   System.out.println ("Frame" ) ;
   System.out.println ("_______________________________________________________________________________") ;
   System.out.println ("  1   |   2   |   3   |   4   |   5   |   6   |   7   |   8   |   9   |   10  |");
   System.out.println ("_______________________________________________________________________________") ;
   System.out.println ("Score") ;
   System.out.println ("_______________________________________________________________________________") ;
   System.out.println ("  " + pointsTotalUser [0]  + "   | " + "  " + pointsTotalUser [1] + "   | " + "  " + pointsTotalUser [2] + "   | " + "  " + pointsTotalUser [3] + "   | " + "  " + pointsTotalUser [4] + "   | "+ "  " + pointsTotalUser [5] + "   | "+ "  " + pointsTotalUser [6] + "   | "+ "  " + pointsTotalUser [7] + "   | " + "  " + pointsTotalUser [8] + "   | " + "  " + pointsTotalUser [9] + "   | ") ;
   System.out.println ("_______________________________________________________________________________") ;
  }
  if ((turn%2 == 0 && tries == 2) || (turn%2 == 0 && tries ==1 && pointsFrameComp == 20)) {//comp
   System.out.println (name [1] + " :") ;
   System.out.println ("Frame" ) ;
   System.out.println ("_______________________________________________________________________________") ;
   System.out.println ("  1   |   2   |   3   |   4   |   5   |   6   |   7   |   8   |   9   |   10  |");
   System.out.println ("_______________________________________________________________________________") ;
   System.out.println ("Score") ;
   System.out.println ("_______________________________________________________________________________") ;
   System.out.println ("  " + pointsTotalComp [0]  + "   | " + "  " + pointsTotalComp [1] + "   | " + "  " + pointsTotalComp [2] + "   | " + "  " + pointsTotalComp [3] + "   | " + "  " + pointsTotalComp [4] + "   | "+ "  " + pointsTotalComp [5] + "   | "+ "  " + pointsTotalComp [6] + "   | "+ "  " + pointsTotalComp [7] + "   | " + "  " + pointsTotalComp [8] + "   | " + "  " + pointsTotalComp [9] + "   | ") ;
   System.out.println ("_______________________________________________________________________________") ;
  }
  messages (tries, pointsFrameUser, turn, amountHit, bumper); //calls for messages method

  if (turn == 20 &&( tries == 2 || (tries ==1 && pointsFrameComp == 20))) {
   System.out.println (name [0]+ "'s FINAL SCORE: "+totalUserScore);
   System.out.println ("COMPUTER FINAL SCORE: "+totalCompScore);
   System.out.println (" ");
  
   if (totalUserScore > totalCompScore) {
    System.out.print ("Congratulations! You have won the game with a total of "+totalUserScore+" points!");
   } else if (totalUserScore < totalCompScore) {
    System.out.println ("The computer has won the game with a total of "+totalCompScore+" points! Better luck next time!");
   } else if (totalUserScore == totalCompScore){
    System.out.println ("You tied the game!");
   }
   
  }
  return ; //return to bowling play method

 }

 public static void messages (int tries, int pointsFrameUser, int turn, int amountHit, String bumper) {//messages method
  if (turn%2 == 1 && tries == 1 && pointsFrameUser == 20) {//output for strike111
   System.out.println ("You got a strike! You have earned 20 points!");
   System.out.println (" ");
  }
  if (turn%2 == 1 && tries == 2 && pointsFrameUser == 15) {//output for spare
   System.out.print ("You hit a spare! You have earned 15 points!");
   System.out.println (" ");
  }
  if (turn%2 == 1 && amountHit == 0 && bumper.equals("n")) {
   System.out.println ("You hit the gutter!") ;
   System.out.println (" ");
  }
 }


}