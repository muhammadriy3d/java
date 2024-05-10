package com.algorithms.binary;

import java.util.Arrays;

public class DepthFirstSearch {

  private Node tree;

  private class Node {
    private int value;
    private Node left;
    private Node right;

    private Node(int value) {
      this.value = value;
    }
  }

  private void treeLeft(Node info, Node node) {
    info.left = node;
  }

  private void treeRight(Node info, Node node) {
    info.right = node;
  }

  public void insert(int item) {
    Node node = new Node(item);

    if (tree == null) {
      tree = node;
      return;
    }

    Node currentNode = tree;

    while (currentNode != null) {
      if (item < currentNode.value) {
        if (currentNode.left == null) {
          treeLeft(currentNode, node);
          return;
        }
        currentNode = currentNode.left;
      } else {
        if (currentNode.right == null) {
          treeRight(currentNode, node);
          return;
        }
        currentNode = currentNode.right;
      }
    }
  }

  public int[] search(int value) {
    int[] arr = new int[50];
    if (tree == null)
      return arr;

    Node current = tree;
    int index = 0;

    while (current != null) {

      if (value < current.value) {
        arr[index] = current.value;
        if (current.value == value) {
          System.out.printf("Found %s at index: %s\n", current.value, index);
          for (int i = 0; i < index; i++) {
            System.out.println("Visited > " + arr[i]);
          }
          return arr;
        }

        current = current.left;
        index++;
      }

      if (value >= current.value) {
        arr[index] = current.value;
        if (current.value == value) {
          System.out.printf("Found %s at index: %s\n", current.value, index);
          for (int i = 0; i < index; i++) {
            System.out.println("Visited > " + arr[i]);
          }
          return arr;
        }
        current = current.right;
        index++;
      }
    }

    System.out.println("Our tree root is: " + tree.value);

    return arr;

  }

  public void print() {

  }
}