/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafarkelgreed.Collections;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
        
// descendingIterator() and descendingSet()
//headSet(), tailSet() and subSet()
//ceiling(), floor(), higher() and lower()
//pollFirst() and pollLast()
public class SetExampleAdvancedCollections {
    public static void main(String[] args) {
        NavigableSet original = new TreeSet();
        original.add("1");
        original.add("2");
        original.add("3");    
        NavigableSet reverseNavigableSet = original.descendingSet();
        System.out.println("/n Reversed the set /n");
        for (Object go : reverseNavigableSet){
            System.out.println(go.toString());
        }
        Iterator reverseIterator = original.descendingIterator();
        System.out.println("/n Iterates through the set in reverse /n");
        while(reverseIterator.hasNext()){
			Object next = reverseIterator.next();
                        System.out.println(next);
		}
        System.out.println("/n creates a subset that is less than the parameter. 2nd optional param makes it inclusive./n");
        NavigableSet headSet = original.headSet("2", true);
        for (Object go : headSet){
            System.out.println(go.toString());
        }
        System.out.println("/n creates a subset that is more than the parameter. 2nd optional param makes it inclusive./n");
        NavigableSet tailSet = original.tailSet("2", true);
        for (Object go : tailSet){
            System.out.println(go.toString());
        }
        System.out.println("/n creates a subset that is between the 2 parameters. can make it inclusive./n");
        SortedSet subSet = original.subSet("2", "3");
        for (Object go : subSet){
            System.out.println(go.toString());
        }
        System.out.println("/n returns the next higher number in the set based on the parameter./n");
        Object higherSet = original.higher("2");
        System.out.println("/n returns the next lower number in the set based on the parameter./n");
        Object lowerSet = original.lower("2");
        System.out.println("/n returns and then removes the first element in the set; based on the parameter./n");
        Object pollFirstSet = original.pollFirst();
        System.out.println("/n returns and then removes the last  element in the set; based on the parameter./n");
        Object pollLastSet = original.pollLast();
    }
}