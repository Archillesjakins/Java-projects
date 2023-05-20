package com.example.demo;

import java.util.Arrays;  // For the Arrays.copyOf() method.

public class StackOfInts {  // (alternate version, using an array)

     static int[] items = new int[1];  // Holds the items on the stack.

    int adds = 0;  // The number of items currently on the stack.

    /**
     * Add N to the top of the stack.
     */
    public void push( int N ) {
        if (adds == items.length) {
            // The array is full, so make a new, larger array and
            // copy the current stack items into it.
            items = Arrays.copyOf( items, 2*items.length );
        }
        items[adds] = N;  // Put N in next available spot.
        adds++;           // Number of items goes up by one.
    }

    /**
     * Remove the top item from the stack, and return it.
     * Throws an IllegalStateException if the stack is empty when
     * this method is called.
     */
    public int pop() {
        if ( adds == 0 )
            throw new IllegalStateException("Can't pop from an empty stack.");
        int topItem = items[adds - 1];  // Top item in the stack.
        adds--;    // Number of items on the stack goes down by one.
        return topItem;
    }

    /**
     * Returns true if the stack is empty.  Returns false
     * if there are one or more items on the stack.
     */
    public boolean isEmpty() {
        return (adds == 0);
    }
/** Returns the items in the stack**/
    public String peek(){
        return Arrays.toString(items);
    }
    /** Returns the size of items in the stack**/

    public int size(){
      return items.length;
    }


} // end class StackOfInts

