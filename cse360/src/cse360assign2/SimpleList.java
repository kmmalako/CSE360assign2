/**
* @author Klowee Malakowsky
* Class ID: 187
* Assignment #2
* 
* CLASS: SimpleList
*
* DESCRIPTION:
* This program makes a list of length 10. You can add values to the 
* beginning of the list, remove a value from the list, and search for
* a value in the list. The variable count keeps track of how many 
* value are in the list. If more than 10 values are added then the 
* list size is increased by 50%. You can also get the value of
* count and the contents of list as a string.
*/

package cse360assign2;

import java.util.Arrays;
import java.lang.Math;

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
	 * If the list is already full then it will increase the 
	 * size of the list by 50% to make room for the new value.
	 * @param value 	integer to add 
	 */
	public void add(int value) {
		count++;
		//check if list is full
		if(count >= list.length) {
			int increase = (list.length / 2);
			int size = list.length + increase;
			int[] copy = new int[size];
			copy[0] = value; //add value to front
			for(int index = 1; index < list.length; index++) {
				copy[index] = list[index-1];
			}
			list = new int[size];
			for(int index = 0; index < copy.length-1; index++) {
				list[index] = copy[index];
			}
		}
		else {
			int[] copy = new int[list.length];
			for(int index = 0; index < count; index++) {
				copy[index] = list[index];
			}
			
			list[0] = value;
			
			for(int index = 0; index < count; index++) {
				list[index+1] = copy[index];
			}
		}
	}
	
	
	/**
	 * The function remove, removes a value from list if it is in list.
	 * It also moves the values over if needed. If the list is 25% empty
	 * then it reduces the size of list.
	 * @param value 	value to be removed
	 */
	public void remove(int value) {
		int removeIndex = -1;
		for(int index = 0; index < list.length-1; index++) {
			if(list[index] == value) {
				removeIndex = index;
				}
			}
		if(removeIndex != -1) {
			for(int index = removeIndex; index < list.length-1; index++) {
				list[index] = list[index+1];
			}
			list[list.length-1] = 0;
			count--;
		}
		int empty = 0;
		int sizePercent = list.length/4;
		for(int index = 0; index < list.length-1; index++) {
			if(list[index] == 0) {
				empty++;
			}
		}
		if(empty >=  sizePercent) {
			int size = list.length - sizePercent;
			int[] copy = new int[size];
			for(int index = 0; index < size-1; index++) {
				copy[index] = list[index];
			}
			list = new int[size];
			for(int index = 0; index < copy.length; index++) {
				list[index] = copy[index];
			}
		}
	}
	
	/**
	 * The function append adds a value to the end of list.
	 * If the list is full then the size of list is increased
	 * by 50% so that there is room to add the value.
	 * @param value		value to append to the array
	 */
	public void append(int value) {
		//check if the list is "full" (count = list.length)
		if (count < list.length) {
			count++;		
			list[list.length-1] = value;			
		}
		else {  //list is full in this case, need to expand the size  
			count++;
			int increase = (list.length / 2);
			int[] copy = new int[list.length + increase];
			for(int index = 0; index < list.length-1; index++) {
				copy[index] = list[index];
			}
			copy[list.length] = value; //append value
			
			list = new int[copy.length];
			for(int index = 0; index < copy.length; index++) {
				list[index] = copy[index];
			}
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
	
	/**
	 * The function first returns the first value in list.
	 * If list is empty it returns -1;
	 * @return firstElement		first element in list
	 */
	public int first() {
		int firstElement = -1;
		if(list != null) {
			firstElement = list[0];
		}
		return firstElement;
	}
	
	/**
	 * The function last returns the last value in list.
	 * If list is empty it returns -1;
	 * @return lastElement		last element in list
	 */
	public int last() {
		int lastElement = -1;
		if(list != null) {
			lastElement = list[list.length-1];
		}
		return lastElement;
	}
	
	/**
	 * 
	 * @return listSize		number of possible locations in list
	 */
	public int size() {
		int listSize = 0;
		if(list != null) {
			listSize = list.length;
		}
		return listSize;
	}
	
	
}

