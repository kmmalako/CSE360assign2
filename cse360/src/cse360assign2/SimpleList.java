/**
* @author Klowee Malakowsky
* Class ID: 142
* Assignment #1
* 
* CLASS: SimpleList
*
* DESCRIPTION:
* This program makes a list of length 10. You can add values to the 
* beginning of the list, remove a value from the list, and search for
* a value in the list. The variable count keeps track of hoe many 
* value are in the list. If more than 10 values are added then the 
* value at the end of the list falls off. You can also get the value of
* count and the contents of list as a string.
*/

package cse360assign2;

import java.util.Arrays;

public class SimpleList {

	//Declare variables
	private int count; 
	private int[] list;
	
	
	/**
	 * Default constructor.
	 * Initializes count and list.
	 */
	public SimpleList() {
		count = 0;
		list = new int[10];
			
	}
	
	
	/**
	 * The function add, adds a value to the beginning of list.
	 * @param value 	integer to add 
	 */
	public void add(int value) {
		//check if the list is "full" (count = 10)
		if (count < 9) {
			count++;
			int[] copy = new int[10];
			for(int index = 0; index < 10; index++) {
				copy[index] = list[index];
			}
			
			list[0] = value;
			
			for(int index = 0; index < count; index++) {
				list[index+1] = copy[index];
			}
			
		}
		else {    //Do not increase count, list is "full"
			count = 10;
			int[] copy = new int[10];
			for(int index = 0; index < 10; index++) {
				copy[index] = list[index];
			}
			list[0] = value;
			for(int index = 0; index < 9; index++) {
				list[index+1] = copy[index];
			}
		}	
	}
	
	
	/**
	 * The function remove, removes a value from list if it is in list.
	 * @param value 	value to be removed
	 */
	public void remove(int value) {
		int removeIndex = -1;
		for(int index = 0; index < 9; index++) {
			if(list[index] == value) {
				removeIndex = index;
				}
			}
		if(removeIndex != -1) {
			for(int index = removeIndex; index < 9; index++) {
				list[index] = list[index+1];
			}
			list[9] = 0;
			count--;
		}
	}
	
	
	/**
	 * The function count gets the value of count.
	 * @return count 	value of count
	 */
	public int count() {
		
		return count;
	}
	
	
	/**
	 * The function toString makes the values in list a string.
	 * @return sList 	contents of list as a string
	 */
	public String toString() {
	
		String sList = Arrays.toString(list); 
		return sList;
	}
	
	
	/**
	 * The function search searches for a value in list.
	 * If it is in list it returns the index it first occurs.
	 * @param value 		value to search for
	 * @return valueIndex 	index the value is at in list	
	 */
	public int search(int value) {
		int valueIndex = -1;
		for(int index = 0; index < count; index++) {
			if(list[index] == value) {
				valueIndex = index;
			}
		}
		return valueIndex;
	}
	
}

