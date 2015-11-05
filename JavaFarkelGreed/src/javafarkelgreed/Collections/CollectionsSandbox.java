/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafarkelgreed.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author zev
 */
public class CollectionsSandbox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        List myCollectionList = new ArrayList();
        NavigableSet myNavigableSet = new TreeSet();
        boolean isOdds = true;
        for(int i = 0; i < 100; i++){
            myCollectionList.add(i);
        }
        System.out.print("Would you like odds(1) or evens(2)?");
        String userString = in.next();
        for (Object list: myCollectionList){
            if ("1".equals(userString)) {
                if ((int)list % 2 == 1){
                    myNavigableSet.add(list);
                }
            } else {
                if ((int)list % 2 == 0){
                    myNavigableSet.add(list);
                    isOdds = false;
                }
            }
        }
        myCollectionList.clear();
        System.out.print("Please pick a number from 0 to 99.");
        int userInt = in.nextInt();
        System.out.println("Do you want 'high' or 'low'?");
        userString = in.next();
        if ("low".equals(userString)){
            myNavigableSet = myNavigableSet.headSet(userInt, true);
        } else {
            myNavigableSet = myNavigableSet.tailSet(userInt, true);
        }
        System.out.println("You have " + myNavigableSet.size() + " numbers remaining.");
        if (isOdds){
            System.out.println("Pick 3, 5, 7, or 9");
            userInt = in.nextInt();
        } else {
            System.out.println("Pick 4, 6, 8, or 10");
            userInt = in.nextInt();
        }
        for (Object set : myNavigableSet){
            for (int i=1; i*userInt < 100; i++){
                if ((int)set == i*userInt){
                    myCollectionList.add(set);
                }
            }
        }
        myNavigableSet.clear();
        System.out.println("Pick a number less than " + myCollectionList.size() + ".");
        userInt = in.nextInt();
        System.out.println("Your lucky number is " + myCollectionList.get(userInt));
    } 
    
}