package com.algorithms.arrays;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {

  private Node first;
  private Node last;

  private class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  // #region - insertFirst/insertLast -
  public void insertFirst(int item) {
    Node node = new Node(item);

    if (isEmpty()) {
      appendNode(node);
    } else {
      node.next = first;
      first = node;
    }
  }

  public void insertLast(int item) {
    Node node = new Node(item);

    if (isEmpty()) {
      appendNode(node);
    } else {
      last.next = node;
      last = node;
    }
  }

  private boolean isEmpty() {
    return first == null;
  }

  private void appendNode(Node node) {
    first = last = node;
  }

  // #endregion

  public int indexOf(int item) {
    int index = 0;
    Node current = first;

    while (current != null) {
      if (current.value == item)
        return index;
      current = current.next;
      index++;
    }
    return -1;
  }

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  public int size() {
    int count = 0;
    Node current = first;
    while (first != null) {
      if (current == null)
        return count;
      current = current.next;
      count++;
    }
    return 0;
  }

  public int[] toArray() {
    int length = size();
    int[] arr = new int[length];

    Node current = first;

    for (int i = 0; i < length; i++) {
      arr[i] = current.value;
      current = current.next;
    }

    return arr;
  }

  public void items() {
    Node current = first;

    while (current != null) {
      System.out.println(current.value);
      current = current.next;
    }
  }

  public void removeFirst() {
    if (isEmpty())
      throw new NoSuchElementException();

    if (first == last) {
      first = last = null;
      return;
    }

    Node second = first.next;
    first.next = null;
    first = second;
  }

  public void removeLast() {
    if (isEmpty())
      throw new NoSuchElementException();

    if (first == last) {
      first = last = null;
      return;
    }

    Node prev = previousNode(last);
    last = prev;
    last.next = null;
  }

  public void removeAt(int index) {
    int i = 0;
    Node current = first;

    if (isEmpty() || index > size() - 1 || index < 0)
      throw new NoSuchElementException();

    if (first == last) {
      first = last = null;
      return;
    }

    while (current != null) {
      if (index == i) {
        Node prev = previousNode(current);

        if (current.next == null && prev != null) {
          last = prev;
          last.next = null;
        } else if (current.next != null && prev == null) {
          Node second = first.next;
          first.next = null;
          first = second;
        } else {
          Node nextToCurrent = current.next;
          current.next = null;
          prev.next = nextToCurrent;
        }
      }
      current = current.next;
      i++;
    }
  }

  private Node previousNode(Node node) {
    Node current = first;

    while (current != null) {
      if (current.next == node)
        return current;
      current = current.next;
    }
    return null;
  }
}