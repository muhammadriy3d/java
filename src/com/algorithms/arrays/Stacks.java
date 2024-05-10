package com.algorithms.arrays;

import java.util.Arrays;

public class Stacks {
  private int[] stacks;
  private int length;
  private int count;
  private int size;

  public Stacks(int length) {
    this.stacks = new int[length];
    this.length = length;
    this.count = length - 1;
    this.size = 0;
  }

  public void insert(int item) {
    if (count > length) {
      int[] tmp = new int[length * 2];
      for (int i = 0; i < count; i++) {
        tmp[i] = stacks[i];
      }
      stacks = tmp;
      tmp = null;
      count = stacks.length - 1;
    }

    if (count > -1)
      stacks[count--] = item;
    size++;
  }

  public int[] toArray() {
    int[] tmp = new int[size];
    for (int i = 0; i < size; i++)
      tmp[i] = stacks[i];
    return tmp;
  }

  public void print() {
    stacks = toArray();
    System.out.println(Arrays.toString(stacks));
  }
}
