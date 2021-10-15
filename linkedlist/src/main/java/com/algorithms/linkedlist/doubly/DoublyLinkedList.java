package com.algorithms.linkedlist.doubly;

/**
 * This class implements all the desirable properties of a doubly liked list.
 */
public class DoublyLinkedList<T> implements LinkedList<T> {
  // Points at the head of the list
  private Node<T> head;
  // Points at the tail of the list. This pointer ensures thatwe dont have to
  // treverse the list to locate the tail (last node of the list)
  private Node<T> tail;

  // Default Constructor
  public DoublyLinkedList() {
    super();
  }

  /**
   * One-Argument Constructor. It initializes the node link
   * 
   * @param head
   */
  public DoublyLinkedList(Node<T> root) {
    this.head = root;
  }

  /* Mutators */
  @Override
  public Node<T> getHead() {
    return head;
  }

  public void setHead(Node<T> head) {
    this.head = head;
  }

  @Override
  public Node<T> getTail() {
    return tail;
  }

  public void setTail(Node<T> tail) {
    this.tail = tail;
  }

  /**
   * This method returns the length of the list
   * 
   * @return legth
   */
  @Override
  public int size() {
    int length = 0;
    Node<T> node = this.head;
    // Loop until no more nodes are available
    while (node != null) {
      length += 1;
      node = node.getNext();
    }
    return length;
  }

  /**
   * This method displays all the node values, from head to tail.
   */
  @Override
  public void display() {
    Node<T> node = this.head;
    while (node != null) {
      System.out.println(node.getData());
      node = node.getNext();
    }
  }

  /**
   * This method inserts a new node at the begining of the list.
   * 
   * @param node
   */
  @Override
  public void add(T data) {
    Node<T> newNode = new Node<>(data);
    // Set the head and tail to be the new node if the list is currently empty
    if (this.head == null)
      this.head = this.tail = newNode;
    else {
      // Set the new node's previous to null
      this.head.setPrev(newNode);
      // Set the newNode's NEXT pointer to point at the current head
      newNode.setNext(this.head);
      // Set the current head's previous pointer to be the new node.
      this.head = newNode;
      // Set the new node to be the new head
      newNode.setPrev(null);
    }
  }

  @Override
  public void append(T data) {
    Node<T> newNode = new Node<>(data);
    // Set the head and tail to be the new node if the list is currently empty
    if (this.tail == null)
      this.head = this.tail = newNode;
    else {
      // Set the new node's next pointer to be null
      this.tail.setNext(newNode);
      // Set the new node's previous pointer to point at the current tail
      newNode.setPrev(this.tail);
      // Set the current tail's next pointer to be the new node
      this.tail = newNode;
      // Set the new node to be the new tail
      newNode.setNext(null);
    }
  }

  @Override
  public void insert(int index, T data) {
    // Get the possible maximum index
    int maxIndex = this.size();

    // Throw an exception if the provided index is out of range
    if (index < 0 || index > maxIndex)
      throw new IndexOutOfBoundsException();

    if (index == 0)
      // Insert the new node at the head/begining of the list if index is zero
      this.add(data);
    else if (index == maxIndex - 1)
      // Insert the new node at the end of the list if index is equals tail node's
      // index
      this.append(data);
    else {
      // Get the node to be shifted from the specified index
      Node<T> node = this.getNodeByIndex(index - 1);
      // Initailize a new node
      Node<T> newNode = new Node<>(data);
      // Set the new node's next pointer to be the next node's next point
      newNode.setNext(node.getNext());
      // set the node's next pointer to be the new node
      node.setNext(newNode);
      // Set the new node's previous pointer to be the node
      newNode.setPrev(node);
      // Set the new node's next pointer to be the itself
      newNode.getNext().setPrev(newNode);
    }
  }

  @Override
  public Node<T> pop() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node<T> remove() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node<T> remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node<T> remove(Node<T> node) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * This method finds the node at the specified index. Return Null if the list is
   * empty, otheweise return the node
   * 
   * @param index
   * @return Node | null
   */
  @Override
  public Node<T> getNodeByIndex(int index) {
    Node<T> node = this.head;
    int count = 0;
    // Loop until the desired node is found
    while (node != null && index != count) {
      count += 1;
      node = node.getNext();
    }
    return node;
  }

  /**
   * This method returns the index that a node occcupies within the list. If the
   * list is empty or the matching node is not found, return negative value (-1),
   * otherwside return the index
   * 
   * @param data
   * @return index | -1
   */
  @Override
  public int getNodeIndex(T data) {
    Node<T> node = this.head;
    int index = 0;
    // Loop until the node is found
    while (node != null && !node.getData().equals(data)) {
      index += 1;
      node = node.getNext();
    }
    // If the list is empty or the node is not found, return -1
    if (index >= this.size())
      return -1;

    return index;
  }

  /**
   * This method checks if the list is empty or not. Return true if empty
   * otherwise false
   * 
   * @return true | fales
   */
  @Override
  public boolean isEmpty() {
    return this.size() == 0;
  }
}
