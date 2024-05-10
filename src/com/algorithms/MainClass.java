package com.algorithms;

import java.util.Arrays;

import com.algorithms.arrays.Array;
import com.algorithms.arrays.LinkedList;
import com.algorithms.arrays.Stacks;
import com.algorithms.binary.DepthFirstSearch;

public class MainClass {
  /**
   * @param args
   */
  public static void main(String[] args) {

    System.out.println("Normal Custom Array");

    Array numbers = new Array(3);

    numbers.insert(100);
    numbers.insert(210);
    numbers.insert(321);
    numbers.insert(432);
    numbers.insert(543);
    numbers.insert(654);
    numbers.insert(765);
    numbers.removeAt(1);
    numbers.print();

    System.out.println("Index of 432 is: " + numbers.indexOf(432));
    System.out.println();
    System.out.println("Linked list");

    LinkedList list = new LinkedList();

    list.insertFirst(20);
    list.insertLast(30);
    list.insertFirst(10);
    list.insertLast(40);
    list.insertFirst(0);

    System.out.println(Arrays.toString(list.toArray()));
    System.out.println("Size of this list is: " + list.size());
    System.out.println("Is this list has a number 0: " + list.contains(0));
    System.out.println("Is this list has a number 5: " + list.contains(5));
    System.out.println("Is this list has a number 10: " + list.contains(10));
    System.out.println("Is this list has a number 20: " + list.contains(20));
    System.out.println("Is this list has a number 30: " + list.contains(30));
    System.out.println("Is this list has a number 40: " + list.contains(40));
    System.out.println("Is this list has a number 50: " + list.contains(50));
    System.out.println("Index of 10 is: " + list.indexOf(1));
    System.out.println("Index of 10 is: " + list.indexOf(10));
    System.out.println("Index of 20 is: " + list.indexOf(20));
    System.out.println("Index of 30 is: " + list.indexOf(30));
    System.out.println("Index of 40 is: " + list.indexOf(40));
    System.out.println("Index of 50 is: " + list.indexOf(50));

    list.removeFirst();
    list.removeLast();
    list.removeAt(1);

    System.out.println("After removing first and last items!");

    list.items();
    System.out.println("After pop " + Arrays.toString(list.toArray()));

    System.out.println("Stacks");
    Stacks stacks = new Stacks(3);

    stacks.insert(1);
    stacks.insert(2);
    stacks.insert(3);
    stacks.print();

    int[] arr = stacks.toArray();
    System.out.println(Arrays.toString(arr));

    // Last in frist out: print it
    System.out.println(arr[0]);

    DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
    depthFirstSearch.insert(8);
    depthFirstSearch.insert(1);
    depthFirstSearch.insert(2);
    depthFirstSearch.insert(3);
    depthFirstSearch.insert(12);
    depthFirstSearch.insert(9);
    depthFirstSearch.insert(20);

    depthFirstSearch.search(0);
  }
}

// 8
// / \
// 1 12
// \ / \
// 2 9 20
// \
// 3

// we need fix balance algorithm for this case!!!!!!!!!!!!!!!
// 8
// / \
// 1 12
// \ / \
// 2 9 20
// \
// 3