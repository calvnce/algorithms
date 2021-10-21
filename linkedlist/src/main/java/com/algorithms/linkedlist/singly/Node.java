package com.algorithms.linkedlist.singly;

import com.algorithms.linkedlist.Data;

/**
 * This is the representation of the List structure. It contains the simple
 * LinkedList data structure.
 */
public class Node {
  private Node next;
  private Data data;

  /**
   * Default Constructor
   */
  public Node() {
    super();
  }

  /**
   * One-Argument constructor for initializing the data
   * 
   * @param data
   */
  public Node(Data data) {
    this.data = data;
  }

  /* Mutators */
  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }
}
