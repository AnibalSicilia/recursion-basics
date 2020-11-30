package a6;

/*  File: ArrayRecursion.java
 *
 *  Programmer: Anibal Sicilia. 
 */

import java.util.Random ;

class ArrayRecursion
{
	// instance var's
	private int [] list ;			// array of ints
	private int count ;			// number of elements used
	private Random r ;
	
	/**
	 * Create an ArrayRecursion object.  
	 * Create an array with between 10 and 15 elements, and fill it with 
	 * random positive 2-digit ints
	 */
	public ArrayRecursion()
	{
            r = new Random() ;
            count = r.nextInt(6) + 10 ;
            list = new int[count] ;

            for (int i = 0 ; i < count ; i++)
                list[i] = r.nextInt(90) + 10 ;
	}
	
	/*
	 * Return the list as a string
	 * @return a string containing all ints stored in list
	 */
	public String toString()
	{
            String out = "" ;
            for (int i = 0 ; i < count ; i++)
                out += list[i] + "  " ;
            return out + "\n" ;
	}

	/**
	 * Reverse the order of the values stored in the list.
	 * (called by client to reverse list using first algorithm)
	 */
	public void reverse()
	{
            reverseRecurse(list, 0, count) ;
	}
	
	// recursive "helper" method to reverse the values stored in the list 
	// (called by public method reverse1())
	// uses the first list reversal algorithm
	private void reverseRecurse ( int[] list, int start, int count )
	{
            if((count-1) < start)   // simplest case for even arrays size
            {
                return;     // do nothing, recursion 'stars back'
            }
            if((count-1) == start)  // simplest case for odd arrays size
            {
                int d = list[count-1];
                list[count-1] = list[start];    // swap inner most integers
                list[start] =  d;
                return;     // recursion 'starts back'
            }

            reverseRecurse(list, start+1, count-1);
            int d = list[count-1];  
            list[count-1] = list[start];    // swap first with last one
            list[start] = d;        // complete the swap
	}
	
	/*
	 * Return the index of the largest value in the array.
	 * @return the index of the largest value in the array
	 */
	public int getIndexOfLargest()
	{
		return recursiveGetIndexOfLargest(list, count) ;
	}
	
	// recursive "helper" method to return the index of thelargest
        // value in the array (called by public method getLargest())
	private int recursiveGetIndexOfLargest( int[] list, int count )
	{
            int largestYet;     // will hold the largest known value
            if(count-1 == 0)    // the simplest case just the largest by now
                return count-1;

            largestYet = recursiveGetIndexOfLargest(list, count-1);
            if(list[count-1] > list[largestYet])    // if value returned is
                largestYet = count-1;               // bigger set new largest
            return largestYet;
            //return -999 ;   // bogus value to enable program skeleton to run
	}
	
	/*
	 * Sort the array in ascending order using the selection sort
	 */
	public void sort()
	{
            recursiveSort(list, count) ;
	}

	// recursive "helper" method to sort the array
	// (called by public method sort())
	private void recursiveSort( int[] list, int count )
	{
            if((count-1) == 0)
            {
                return;
            }
            else
            {
                int c = getIndexOfLargest();
                int d = list[c];    // obtain the largest value at the index
                list[c] = list[count - 1];  // swap it with the last
                list[count-1] = d;
       // this.count is an instance variable needs to be decreased here or 
       // getIndexOfLargest method will always loop using the whole list length
       // returning always the same biggest value. I here simulate the size of
       // the array by always 'reducing it' on each call to the count-1 value.
                this.count = count-1;   
                recursiveSort(list, count-1);
                
            }
            this.count = list.length;   // 'return' the original value to count
	}
}

/**
 * A test class for the ArrayRecursion class
 */
public class ArrayRecursionTest
{
    public static void main(String[] args)
    {
        ArrayRecursion list = new ArrayRecursion() ;

        System.out.println("\nOriginal:  " + list) ;
        list.reverse() ;
        System.out.println("\nReversed:    " + list) ;
        System.out.println("Index of the Largest Value: " +
                            list.getIndexOfLargest()) ;
        list.sort() ;
        System.out.println("\nSorted:    " + list) ;
    }
}
