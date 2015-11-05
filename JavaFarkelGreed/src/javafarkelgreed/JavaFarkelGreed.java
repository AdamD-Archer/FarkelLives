 /*
 * Adam Decker
 * 2015 
 */
package javafarkelgreed;

import Model.Players;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author zev
 */

public class JavaFarkelGreed {
    public static ArrayList<Players> playersInGame = new ArrayList<>();
    public static boolean lastRound = false;
    public static Random rdm = new Random();
    public static int skipPlayer = 100;
    public static int diceLeft;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // code application logic here\
//        sets up a 2 player game with one human and one CPU for building the game.
//        TODO - have user select number of players and enter names or if they are a CPU. Dynamically buid players off of user inputs.
        playersInGame.add(new Players("Izzy", 0, true));
        playersInGame.add(new Players("Adam", 1, false));
//        runs as long as no player's score is above 10000.
        do {            
            executeRound();
            for (int i = 0; i < playersInGame.size(); i++) {
                if (playersInGame.get(i).getScore() > 10000){
                    lastRound = true;
                    skipPlayer = i;
                }
            }
        } while (!lastRound);
        executeRound();
//        outputs the end of game results.
//        TODO dynamic output based on number of players.
        System.out.println("The game has ended. here are the results: "
                + "\n " + playersInGame.get(0).getName() + " has " + playersInGame.get(0).getScore() + " points."
                + "\n " + playersInGame.get(1).getName() + " has " + playersInGame.get(1).getScore() + " points.");
    }
//    **************************************************************************
//    function that controls the round logic.
    private static void executeRound() {
        for (int i = 0; i < playersInGame.size(); i++) {
            turn(playersInGame.get(i));
        }
        return;
    }
//    **************************************************************************
//    function that controls the turn logic per player.
    public static void turn(Players player){
//        if statement will skip a single player during final round of game.
        if (player.getArrayPosition() == skipPlayer) {
            return;
        }
        diceLeft = 6;
        boolean bustFarkel = false;
        int turnScore = 0;
        ArrayList<Integer> dicekept = new ArrayList<>();
//        runs as long as a player doesnt bust/farkel
        while (!bustFarkel) {                         
            ArrayList<Integer> diceRollResults = rollDice(diceLeft);
            diceRollResults.sort(null);
            System.out.println( player.getName() + ", For this TURN you have rolled " + turnScore + " points.");
            if (diceLeft == 6) {
                boolean result = checkSix(diceRollResults);
                if (result) {
                    System.out.println("\n $$$$$$ CELEBRATE! $$$$$$"
                            + "\n You used all six dice! "
                            + "\n You get to roll again.");
                    turnScore += 1500;
                    continue;
                }
            }
//            check for bust/farkel
            bustFarkel = true;
            for (int i = 1; i < 7; i++) {
                int atLeastTriple = numberOfMatchingDice(i, diceRollResults);
                int anyOnes = numberOfMatchingDice(1, diceRollResults);
                int anyFives = numberOfMatchingDice(5, diceRollResults);
                if (atLeastTriple > 2) {
                      bustFarkel = false;
                      break;
                } else if (anyOnes > 0 || 
                anyFives > 0) {
                bustFarkel = false;
                break;
                } else {
                    continue;
                }
            }
            if (bustFarkel) {
                System.out.println("****** OH! NO! ****** "
                        + "\n\n    Whoops, you farkeled. "
                        + "\n ****** NEXT! ******");
                continue;
            }
//            possible area for AI vs. Human break off.
//            has user pick dice from roll to keep.
            dicekept = pickDice(diceRollResults);
//            removes the amount of dice the user kept from the available pool.
            diceLeft -= dicekept.size();
//            evaluates the score of the kept dice
            turnScore += analyzeDice(dicekept);
//            if you roll all the dice you have to roll again!
            if (diceLeft == 0) {
                        diceLeft = 6;
                        System.out.println("\n ###### YOU DID IT! ######"
                                + "\n You have to roll again. With 6 dice! "
                                + "\n ###### Good For You ######");
                        continue;
                    }
//            Checks for roll or stay from user
            System.out.println("How greedy are you? "
                    + "\n Type  1  to roll again."
                    + "\n Type  2  to keep and end your turn."
                    + "\n Your TURN score is -" + turnScore 
                    + "\n Your TOTAL score can be - " + (player.getScore() + turnScore)
                    + "\n You have " + diceLeft + " dice left. Will you risk it?");
            boolean valid = false;
            int greedCheck = 0;
            while(!valid) {
                Scanner keyboard = new Scanner(System.in);
                greedCheck = keyboard.nextInt();
                if (greedCheck < 1 || 
                    greedCheck > 2) {
                    System.out.println("Invalid option please select 1 to roll or 2 to stay.");
                } else {
                    valid = true;
                }
            }
            switch (greedCheck) {
                case 1:
                    continue;
                case 2:
                    player.setScore(player.getScore() + turnScore);
                    return;
            }
        }
    }
//    **************************************************************************
// rolls any amount of dice. returns array of dice values.
    public static ArrayList<Integer> rollDice(int numOfDice) {
	ArrayList<Integer > rolls = new ArrayList<>();
	for (int i = 0; i < numOfDice; i++) {
            rolls.add(1 + rdm.nextInt(6));
        }
	return rolls;
    }
//    **************************************************************************
//    checks six dice for an immediate score and re-roll.
    public static boolean checkSix(ArrayList<Integer> diceRollResults) {
//        check for 1-6 run
        boolean hasRun = true;
        for (int i = 1; i < 7; i++) {
            if (diceRollResults.contains(i)){
            } else {
                 hasRun = false;
            }
        }
        if (hasRun) {
            return true;
        }
//        checks for six of a kind
        for (int j = 1; j < 7; j++) {
            if (numberOfMatchingDice(j, diceRollResults) == 6){
                return true;
            }
        }
//        checks for three pairs
        int pairCount = 0;
        int fourCount = 0;
        for (int k = 1; k < 7; k++) {
            int bang = numberOfMatchingDice(k, diceRollResults);
            if (bang == 2){
                pairCount++;
            }
            if (bang == 4) {
                fourCount++;
            }
        }
        if (pairCount == 3 || 
           (pairCount == 1 && fourCount == 1)) {
            return true;
        }
//            check for two triplets
        int tripleCount = 0;
        for (int k = 1; k < 7; k++) {
            if (numberOfMatchingDice(k, diceRollResults) == 3){
                tripleCount++;
            }
        }
        if (tripleCount == 2) {
            return true;
        }
        return false;
    }
//    **************************************************************************
//    returns the number of dice that match: inputs = desired number to match and the array of dice values.
    public static int numberOfMatchingDice(int goal, ArrayList<Integer> diceToCheck) {
        int count = 0;
        for (int die : diceToCheck) {
            if (goal == die) {
                count++;
            }
        }
        return count;
    }
//    **************************************************************************
//     prints dice values and asks Human user which ones they want to keep. returns an array of all the kept dice values.
    private static ArrayList<Integer> pickDice(ArrayList<Integer> rollResults) {
        ArrayList<Integer> diceSelected = new ArrayList<>();
        boolean pickMore = true;
        rollResults.add(0);
        rollResults.add(0);
        rollResults.add(0);
        rollResults.add(0);
        rollResults.add(0);
        rollResults.add(0);
        do {            
            System.out.println("Select the letter of the dice value you want to keep. Pick one at a time or select 'Q' to quit.");
            System.out.println("  A: " + rollResults.get(0) 
                    + "\n  B: " + rollResults.get(1) 
                    + "\n  C: " + rollResults.get(2) 
                    + "\n  D: " + rollResults.get(3) 
                    + "\n  E: " + rollResults.get(4) 
                    + "\n  F: " + rollResults.get(5) );
            boolean valid = false;
            String response;
            Scanner keyboard = new Scanner(System.in);
            while (!valid) {                
                response = keyboard.nextLine();
                response = response.trim();
                response = response.toUpperCase();
                if (response.equals("Q") && diceSelected.isEmpty()) {
                    System.out.println("You have to pick at least one.");
                    continue;
                } else if (response.equals("Q")) {
                    pickMore = false;
                    break;
                }
                if (response.equals("1") || response.equals("2")) {
                    System.out.println("Invalid Input - Those options are not available here. Try again.");
                    continue;
                }
                if (response.length() == 0 || 
                    response.length() > 1) {
                    System.out.println("Invalid Input - Must not be blank or more than one character. Try again.");
                    continue;
                }
                switch (response) {
                    case "A":
                        if (rollResults.get(0) == 0) {
                            System.out.println("Invalid - dice value cannot be zero.");
                            break;
                        }
                        diceSelected.add(rollResults.get(0));
                        rollResults.remove(rollResults.get(0));
                        valid = true;
                        break;
                    case "B":
                        if (rollResults.get(1) == 0) {
                            System.out.println("Invalid - dice value cannot be zero.");
                            break;
                        }
                        diceSelected.add(rollResults.get(1));
                        rollResults.remove(rollResults.get(1));
                        valid = true;
                        break;
                    case "C":
                        if (rollResults.get(2) == 0) {
                            System.out.println("Invalid - dice value cannot be zero.");
                            break;
                        }
                        diceSelected.add(rollResults.get(2));
                        rollResults.remove(rollResults.get(2));
                        valid = true;
                        break;
                    case "D":
                        if (rollResults.get(3) == 0) {
                            System.out.println("Invalid - dice value cannot be zero.");
                            break;
                        }
                        diceSelected.add(rollResults.get(3));
                        rollResults.remove(rollResults.get(3));
                        valid = true;
                        break;
                    case "E":
                        if (rollResults.get(4) == 0) {
                            System.out.println("Invalid - dice value cannot be zero.");
                            break;
                        }
                        diceSelected.add(rollResults.get(4));
                        rollResults.remove(rollResults.get(4));
                        valid = true;
                        break;
                    case "F":
                        if (rollResults.get(5) == 0) {
                            System.out.println("Invalid - dice value cannot be zero.");
                            break;
                        }
                        diceSelected.add(rollResults.get(5));
                        rollResults.remove(rollResults.get(5));
                        valid = true;
                        break;
                    default:
                        System.out.println("\n*** Invalid selction *** Try Again");
                        break;
                }
            }
        } while (pickMore);
        return diceSelected;
    }
//    **************************************************************************
//    returns an int based off the scoring value of the dice being kept by the player. re-adds none-scoring dice to dice pool(diceLeft)
    public static int analyzeDice(ArrayList<Integer> diceToCheck) {
        int returnNumber = 0;
        for (int i = 1; i < 7; i++) {
            int numberOfDiceByValue = numberOfMatchingDice(i, diceToCheck);
            if (numberOfDiceByValue == 0) {
                continue;
            }
            if (numberOfDiceByValue == 5) {
                returnNumber += 1400;
            }
            if (numberOfDiceByValue == 4) {
                switch (i) {
                    case 1 :
                        returnNumber += 1400;
                        break;
                    case 2 :
                        returnNumber += 400;
                        break;
                    case 3 :
                        returnNumber += 600;
                        break;
                    case 4 :
                        returnNumber += 800;
                        break;
                    case 5 :
                        returnNumber += 1000;
                        break;
                    case 6 :
                        returnNumber += 1200;
                        break;
                }
            }
            if (numberOfDiceByValue == 3) {
                switch (i) {
                    case 1 :
                        returnNumber += 700;
                        break;
                    case 2 :
                        returnNumber += 200;
                        break;
                    case 3 :
                        returnNumber += 300;
                        break;
                    case 4 :
                        returnNumber += 400;
                        break;
                    case 5 :
                        returnNumber += 500;
                        break;
                    case 6 :
                        returnNumber += 600;
                        break;
                }
            }
            if (numberOfDiceByValue < 3){
                if (i == 1 || 
                    i == 5) {
                    switch (i) {
                    case 1 :
                        returnNumber += 100 * numberOfDiceByValue;
                        break;
                    case 5 :
                        returnNumber += 50 * numberOfDiceByValue;
                        break;
                    }
                } else {
                    System.out.println("You can't keep dice that have no point value. Read the rules!");
                    diceLeft += numberOfDiceByValue;
                }
            }
        }
        return returnNumber;
    }
    // ***************************************************
    // getter and setters

    

   
    
}