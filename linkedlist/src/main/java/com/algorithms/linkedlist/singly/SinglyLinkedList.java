package com.algorithms.linkedlist.singly;

public class SinglyLinkedList {
  private Node head;
  private Node tail;

  public SinglyLinkedList() {
    super();
  }

  /**
   * This method inserts the node at the begining of the list. Returns null if the
   * provided node is null, otherwise retuns the new head.
   * 
   * @param node
   * @return head|null
   */
  public Node add(Node node) {
    if (node != null) {
      if (this.head == null) {
        // Set the head to be the new node, if the current head null
        this.head = this.tail = node;
      } else {
        // Sold the current head
        Node currentHead = this.head;
        // Set the new head to be the newly provided head
        this.head = node;
        // Set the new head's next pointer to point to the previous head - represented
        // by the current head variable
        this.head.setNext(currentHead);
      }
      return this.head;
    }
    return null;
  }

  /**
   * This method inserts the new node at the end of the list. If the provided node
   * is return null otherwise return the new tail
   * 
   * @param node
   * @return tail|null
   */
  public Node append(Node node) {
    if (node != null) {
      if (this.tail == null) {
        // Set the head to be the new node, if the current head null
        this.head = this.tail = node;
      } else {
        // Holds the current tail
        Node currentTail = this.tail;
        // Set the tail to be the provided node
        this.tail = node;
        // Set the previous tail's pointer - represented by currentTail varible to point
        // at the newly set tail.
        currentTail.setNext(this.tail);
      }
      return this.tail;
    }
    return null;
  }

  /**
   * This method inserts the node at the provided index.
   * 
   * The following is the assumption made: If the index is out of bounds (0 <
   * index >= size of list) then the node is inserted at the node of the list
   * (appended to the list).
   * 
   * The method returns null if node is null othrwise return the inserted node.
   * 
   * @param node
   * @param index
   * @return node|null
   */
  public Node insert(Node node, int index) {
    if (node != null) {
      Node nextNode = new Node();
      // Set tne new node to be the head if the provided index is zero
      if (index == 0)
        nextNode = this.add(node);
      // Set the new node at the end of the list if the index is negative or greater
      // than the possible max index
      else if (index >= this.size() || index < 0)
        nextNode = this.append(node);
      else {
        // Holds the node before the specified index
        Node previousNode = this.getNode(index - 1);
        // Holds the node at the specified index
        Node currentNode = this.getNode(index);
        // Set the previou node's next pointer to the new node
        previousNode.setNext(node);
        // Set the newly inserted node's next pointer to point at the next node -
        // represented by the currentNode variable
        node.setNext(currentNode);
        // Set the node to be returned
        nextNode = previousNode.getNext();
      }
      return nextNode;
    }
    return null;
  }

  /**
   * This method removes the node at the top (start) of the list. Returs the
   * removed node otherwise retruns null if list is empty
   * 
   * @return Node|null
   */
  public Node remove() {
    if (this.head != null) {
      // Set the mode to be removed
      Node removedNode = this.head;
      // set the tail and head to be null since the list has only one element
      if (this.head == this.tail)
        this.head = this.tail = null;
      else
        // Set the new node to be next node.
        this.head = this.head.getNext();

      return removedNode;
    }
    return null;
  }

  /**
   * This method removes the last node from the list. It returns the removed node,
   * otherwise return null if the list is empty
   * 
   * @return Node|null
   */
  public Node pop() {

    if (this.tail != null) {
      // Set the mode to be removed
      Node removedNode = this.tail;
      // set the tail and head to be null since the list has only one element
      if (this.head == this.tail)
        this.head = this.tail = null;
      else {
        // Holds the node before the tail
        Node node = this.getNode(this.size() - 2);
        // Set the second last node to be last node.
        this.tail = node;
        // Set the last node explicitly to null;
        node.setNext(null);
      }
      return removedNode;
    }
    return null;
  }

  /**
   * This method removes the node at the specified index.
   * 
   * The following is the assumption made: If the index is out of bounds (0 <
   * index >= size of list) then the last node of the list is removed.
   * 
   * The method returns null if node is null othrwise return the removed node.
   * 
   * @param index
   * @return Node|null
   */
  public Node remove(int index) {
    if (index == 0)
      this.remove();
    else if (index < 0 || index >= this.size() || index == this.size() - 1)
      this.pop();
    else {
      // Hold the node to be removed
      Node removedNode = this.getNode(index);
      // Hold the node before the specified index
      Node nodeBeforeIndex = this.getNode(index - 1);
      // Hold the node after the specified index
      Node nodeAfterIndex = this.getNode(index + 1);
      // Set the node before the index's next pointer to point at the node after the
      // index
      nodeBeforeIndex.setNext(nodeAfterIndex);
      return removedNode;
    }
    return null;
  }

  /**
   * This method removes the node at the specified index. The method returns null
   * if node is null othrwise return the removed node.
   * 
   * @param index
   * @return Node|null
   */
  public Node remove(Node node) {
    // Throw an exception if the provided node is null
    if (node == null)
      throw new IllegalArgumentException("Provided Object is null");
    // Get the index of the node to remove
    int index = this.getNodeIndex(node);
    // Remove the node at the index if the index is valid
    if (index != -1) {
      this.remove(index);
    }
    return null;
  }

  /**
   * This method gets the node at the specified index. This method does not
   * consider the extreems because the possible extremes are taken care of by the
   * implementing (or consuming) function.
   * 
   * @param index
   * @return Node
   */
  private Node getNode(int index) {
    Node node = this.head;
    int count = 0;
    while (node != null && count != index) {
      count += 1;
      node = node.getNext();
    }
    return node;
  }

  /**
   * This method move through the list to find the first matching instance of the
   * provided node. If the match is not found it returns a negative interger
   * otherwise returns the valide index.
   * 
   * @param node
   * @return index | -1
   */
  private int getNodeIndex(Node node) {
    int index = -1;
    Node curreNode = this.head;
    // Loop untill the matching node is found
    while (curreNode != null && curreNode != node) {
      index += 1;
      curreNode = curreNode.getNext();
    }
    return index;
  }

  /**
   * This method computes the length or size of the list. It retuns zero(0) if the
   * list is empty, otherwise return the computed length.
   * 
   * @return length|0
   */
  public int size() {
    int length = 0;
    // Points to the head of the node
    Node currentNode = this.head;
    // Loop until there is no node left
    while (currentNode != null) {
      length += 1;
      currentNode = currentNode.getNext();
    }
    return length;
  }

  /* Mutators */
  public Node getHead() {
    return head;
  }

  public void setHead(Node head) {
    this.head = head;
  }

  public Node getTail() {
    return tail;
  }

  public void setTail(Node tail) {
    this.tail = tail;
  }
}
