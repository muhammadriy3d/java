package com.algorithms.arrays;

public class Array {
  private int[] array;
  private int length;
  private int size;
   
  public Array(int length) {
    this.array = new int[length];
    this.size = 0;
    this.length = length;
  }

  public void insert(int i) {
    if (length <= size)
    {
      int[] temp = new int[size*2];
      for (int l = 0; l < size; l++)
        temp[l] = array[l];
      array = temp;
    }

    array[size] = i;
    size++;
  }

  public void removeAt(int index)
  {
    if (index >= size || index < 0)
      throw new IllegalArgumentException();

    for (int i = index; i < size; i++)
      array[i] = array[i + 1];

    size--;
  }

  public void print() {
    for (int i = 0; i < size; i++)
      System.out.println(array[i]);
  }

  public int indexOf(int target)
  {
    // Worst case senario O(n)
    for (int j = 0; j < size; j++) {
      if (array[j] == target) {
        return j;
      }
    }
    return -1;
  }
}
