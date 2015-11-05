/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafarkelgreed.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExampleBasicCollections {
	public static void main(String[] args) {
		List myList = new ArrayList();
		// How to add to and ArrayList
		myList.add("Object 1");
		myList.add("Object 2");
		myList.add("Object 3");
		// How to remove from an ArrayList
		myList.remove(2);
		// How to retrieve from the ArrayList
		String newVar = (String) myList.get(0);
                System.out.println("\n retrieves position 0 \n" + (String) myList.get(0));
		// How to count how many items are in the ArrayList or to get the size
		myList.size();
                System.out.println("\n shows the size of the Array \n" + myList.size());
		// 3 ways to iterate
		// 1 old
                System.out.println("\n Iterates by iterator \n");
		Iterator iterator = myList.iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
                        System.out.println(next);
		}
		// 2 for each loop
                System.out.println("\n Iterates by for each loop \n");
		for(Object next : myList){
			String currentObject = (String) next;
                        System.out.println(currentObject);
		}
		// 3 for loop
                System.out.println("\n Iterates by for loop \n");
		for(int i=0; i < myList.size(); i++){
			Object nowIs = myList.get(i);
                        System.out.println(nowIs);
		}
		// How to clear an ArrayList
		myList.clear();
		// creating a type specific ArrayList
		List<String> myListTwo = new ArrayList<>();
	}
}