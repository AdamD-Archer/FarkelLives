/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafarkelgreed;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zev 
 */
public class JavaFarkelGreedTest {
    
    /**
     * Test of rollDice method, of class JavaFarkelGreed.
     */
    @Test
    public void testRollDice() {
        System.out.println("rollDice");
        /********************************
         *  Test case #1
         *******************************/
        System.out.println("\tTest case #1"
                + "\n\t\t 0 dice = empty array");
        int numOfDice = 0;
        ArrayList<Integer> expResult = new ArrayList<>();
        ArrayList<Integer> result = JavaFarkelGreed.rollDice(numOfDice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRollDice2() {
        /********************************
         *  Test case #2
         *******************************/
        System.out.println("\tTest case #2"
                + "\n\t\t 1 dice = array size of 1");
        int numOfDice = 1;
        int expResult = numOfDice;
        
        ArrayList<Integer> callToFuction = JavaFarkelGreed.rollDice(numOfDice);
        int result = callToFuction.size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRollDice3() {
        /********************************
         *  Test case #3
         *******************************/
        System.out.println("\tTest case #3"
                + "\n\t\t 2 dice = array size of 2");
        int numOfDice = 2;
        int expResult = numOfDice;
        
        ArrayList<Integer> callToFuction = JavaFarkelGreed.rollDice(numOfDice);
        int result = callToFuction.size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRollDice4() {
        /********************************
         *  Test case #4
         *******************************/
        System.out.println("\tTest case #4"
                + "\n\t\t 3 dice = array size of 3");
        int numOfDice = 3;
        int expResult = numOfDice;
        
        ArrayList<Integer> callToFuction = JavaFarkelGreed.rollDice(numOfDice);
        int result = callToFuction.size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRollDice5() {
        /********************************
         *  Test case #5
         *******************************/
        System.out.println("\tTest case #5"
                + "\n\t\t 4 dice = array size of 4");
        int numOfDice = 4;
        int expResult = numOfDice;
        
        ArrayList<Integer> callToFuction = JavaFarkelGreed.rollDice(numOfDice);
        int result = callToFuction.size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRollDice6() {
        /********************************
         *  Test case #6
         *******************************/
        System.out.println("\tTest case #6"
                + "\n\t\t 5 dice = array size of 5");
        int numOfDice = 5;
        int expResult = numOfDice;
        
        ArrayList<Integer> callToFuction = JavaFarkelGreed.rollDice(numOfDice);
        int result = callToFuction.size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRollDice7() {
        /********************************
         *  Test case #7
         *******************************/
        System.out.println("\tTest case #7"
                + "\n\t\t 6 dice = array size of 6");
        int numOfDice = 6;
        int expResult = numOfDice;
        
        ArrayList<Integer> callToFuction = JavaFarkelGreed.rollDice(numOfDice);
        int result = callToFuction.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckSix() {
        System.out.println("checkSix");
        /********************************
         *  Test case #1
         *******************************/
        System.out.println("\tTest case #1"
                + "\n\t\t not all used 1,1,2,3,4,5");
        ArrayList<Integer> diceRollResults = new ArrayList<>();
        diceRollResults.add(1);
        diceRollResults.add(1);
        diceRollResults.add(2);
        diceRollResults.add(3);
        diceRollResults.add(4);
        diceRollResults.add(5);
        boolean expResult = false;
        boolean result = JavaFarkelGreed.checkSix(diceRollResults);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckSix2() {
        /********************************
         *  Test case #2
         *******************************/
        System.out.println("\tTest case #2"
                + "\n\t\t all used 3 2-of-a-kinds 1,1,2,2,4,4");
        ArrayList<Integer> diceRollResults = new ArrayList<>();
        diceRollResults.add(1);
        diceRollResults.add(1);
        diceRollResults.add(2);
        diceRollResults.add(2);
        diceRollResults.add(4);
        diceRollResults.add(4);
        boolean expResult = true;
        boolean result = JavaFarkelGreed.checkSix(diceRollResults);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckSix6() {
        /********************************
         *  Test case #6
         *******************************/
        System.out.println("\tTest case #6"
                + "\n\t\t all used 4-of-a-kind & 2-of-a-kind 2,2,2,2,4,4");
        ArrayList<Integer> diceRollResults = new ArrayList<>();
        diceRollResults.add(1);
        diceRollResults.add(1);
        diceRollResults.add(2);
        diceRollResults.add(2);
        diceRollResults.add(4);
        diceRollResults.add(4);
        boolean expResult = true;
        boolean result = JavaFarkelGreed.checkSix(diceRollResults);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testCheckSix3() {
        /********************************
         *  Test case #3
         *******************************/
        System.out.println("\tTest case #3"
                + "\n\t\t all used 2 3-of-a-kind 2,2,2,4,4,4");
        ArrayList<Integer> diceRollResults = new ArrayList<>();
        diceRollResults.add(2);
        diceRollResults.add(2);
        diceRollResults.add(2);
        diceRollResults.add(4);
        diceRollResults.add(4);
        diceRollResults.add(4);
        boolean expResult = true;
        boolean result = JavaFarkelGreed.checkSix(diceRollResults);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckSix4() {
        /********************************
         *  Test case #4
         *******************************/
        System.out.println("\tTest case #4"
                + "\n\t\t all used 6-of-a-kind 2,2,2,2,2,2");
        ArrayList<Integer> diceRollResults = new ArrayList<>();
        diceRollResults.add(2);
        diceRollResults.add(2);
        diceRollResults.add(2);
        diceRollResults.add(2);
        diceRollResults.add(2);
        diceRollResults.add(2);
        boolean expResult = true;
        boolean result = JavaFarkelGreed.checkSix(diceRollResults);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckSix5() {
        /********************************
         *  Test case #5
         *******************************/
        System.out.println("\tTest case #5"
                + "\n\t\t all used run 1,2,3,4,5,6");
        ArrayList<Integer> diceRollResults = new ArrayList<>();
        diceRollResults.add(1);
        diceRollResults.add(2);
        diceRollResults.add(3);
        diceRollResults.add(4);
        diceRollResults.add(5);
        diceRollResults.add(6);
        boolean expResult = true;
        boolean result = JavaFarkelGreed.checkSix(diceRollResults);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumberOfMatchingDice3() {
        System.out.println("\tnumberOfMatchingDice");
        /********************************
         *  Test case #3
         *******************************/
        System.out.println("\tTest case #1"
                + "\n\t\t return 0 with 2,2,3,4,5,6 -looking for 1s");
        int goal = 1;
        ArrayList<Integer> diceToCheck = new ArrayList<>();
        diceToCheck.add(2);
        diceToCheck.add(2);
        diceToCheck.add(3);
        diceToCheck.add(4);
        diceToCheck.add(5);
        diceToCheck.add(6);
        int expResult = 0;
        int result = JavaFarkelGreed.numberOfMatchingDice(goal, diceToCheck);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumberOfMatchingDice1() {
        System.out.println("\tnumberOfMatchingDice");
        /********************************
         *  Test case #1
         *******************************/
        System.out.println("\tTest case #1"
                + "\n\t\t return 1 with 1,2,3,4,5,6 -looking for 2s");
        int goal = 2;
        ArrayList<Integer> diceToCheck = new ArrayList<>();
        diceToCheck.add(1);
        diceToCheck.add(2);
        diceToCheck.add(3);
        diceToCheck.add(4);
        diceToCheck.add(5);
        diceToCheck.add(6);
        int expResult = 1;
        int result = JavaFarkelGreed.numberOfMatchingDice(goal, diceToCheck);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumberOfMatchingDice2() {
        /********************************
         *  Test case #2
         *******************************/
        System.out.println("\tTest case #2"
                + "\n\t\t return 3(multiple) with 3,4,4,4,5,6 -looking for 4s");
        int goal = 4;
        ArrayList<Integer> diceToCheck = new ArrayList<>();
        diceToCheck.add(4);
        diceToCheck.add(4);
        diceToCheck.add(3);
        diceToCheck.add(4);
        diceToCheck.add(5);
        diceToCheck.add(6);
        int expResult = 3;
        int result = JavaFarkelGreed.numberOfMatchingDice(goal, diceToCheck);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAnalyzeDice1() {
        System.out.println("analyzeDice");
        /********************************
         *  Test case #1
         *******************************/
        System.out.println("\tTest case #1"
                + "\n\t\t return 1400 with 4,4,4,4,4 -looking for 4s");
        ArrayList<Integer> diceToCheck = new ArrayList<>();
        diceToCheck.add(4);
        diceToCheck.add(4);
        diceToCheck.add(4);
        diceToCheck.add(4);
        diceToCheck.add(4);
        int expResult = 1400;
        int result = JavaFarkelGreed.analyzeDice(diceToCheck);
        assertEquals(expResult, result);
    }
    
        
    @Test
    public void testAnalyzeDice2() {
        /********************************
         *  Test case #2
         *******************************/
        System.out.println("\tTest case #2"
                + "\n\t\t return 800 with 4,4,4,4 -looking for 4s");
        ArrayList<Integer> diceToCheck = new ArrayList<>();
        diceToCheck.add(4);
        diceToCheck.add(4);
        diceToCheck.add(4);
        diceToCheck.add(4);
        int expResult = 800;
        int result = JavaFarkelGreed.analyzeDice(diceToCheck);
        assertEquals(expResult, result);
    }
    
        
    @Test
    public void testAnalyzeDice3() {
        /********************************
         *  Test case #3
         *******************************/
        System.out.println("\tTest case #3"
                + "\n\t\t return 1400 with 4,4,4 -looking for 4s");
        ArrayList<Integer> diceToCheck = new ArrayList<>();
        diceToCheck.add(4);
        diceToCheck.add(4);
        diceToCheck.add(4);
        int expResult = 400;
        int result = JavaFarkelGreed.analyzeDice(diceToCheck);
        assertEquals(expResult, result);
    }
    
        
    @Test
    public void testAnalyzeDice4() {
        /********************************
         *  Test case #4
         *******************************/
        System.out.println("\tTest case #4"
                + "\n\t\t return 200 with 1,5,5 -looking for 1s & 5s");
        ArrayList<Integer> diceToCheck = new ArrayList<>();
        diceToCheck.add(1);
        diceToCheck.add(5);
        diceToCheck.add(5);
        int expResult = 200;
        int result = JavaFarkelGreed.analyzeDice(diceToCheck);
        assertEquals(expResult, result);
    }
}


