/**
 * This class is a representation of the node structure that forms
 * the basic unit of the linked list data structure
 */
class Node {
  /**
   * This constructor initializes the Node properties of the node structure
   * @param {*} val
   */
  constructor(val) {
    this.data=val;
    this.next=null;
    this.prev=null;
  }
}

/**
 * This class implements the Doubly linked list data structure properties
 */
class DoublyLinkedList {
  /**
   * This constructor initializes the head and tail of the list
   */
  constructor() {
    this.head = null;
    this.tail = null;
  }

  /**
   * Insert the node at the beginning of the list
   * @param {*} data
   */
  add = (data) => {
    // Initialize the new node to be inserted into the list
    const newNode = new Node(data);
    if (this.head === null) {
      // Set the head and tail to be the new node if the list is empty
      this.head = this.tail = newNode;
    } else {
      // Set the current head's previous pointer to be the new node
      this.head.prev = (newNode);
      // Set the new node's next pointer to be the current head
      newNode.next = (this.head);
      // Set the new node to be the current head
      this.head = newNode;
      // Set the new node's previous pointer to be null
      newNode.prev = (null);
    }
  };

  /**
   * Insert the node at the end of the list
   * @param {*} data
   */
  append = (data) => {
    // Initialize the new node to be inserted into the list
    const newNode = new Node(data);
    if (this.tail === null) {
      // Set the head and tail to be the new node if the list is empty
      this.tail = this.head=newNode;
    } else {
      // Set the current tail's next pointer to be the new node
      this.tail.next = newNode;
      // Set the new node's prev pointer to be the current tail
      newNode.prev = this.tail;
      // Set the tail to be the new node
      this.tail = newNode;
      // Set the new node's next to be null - end of list
      newNode.next = null;
    }
  };
  /**
   * Insert the node at the specified index
   * @param {Number} index
   * @param {*} data
   */
  insert = (index, data) => {
    // Get the possible size of the list
    const maxIndex = this.size();
    // Throw an error if the provided index is out of range
    if (index < 0 || index > maxIndex) {
      throw new Error(`Index :${index} is out of range`);
    }
    // Insert the node at the start of the list if index is 0
    if (index===0) {
      this.add(data);
    } else if (index===maxIndex - 1) {
      // eslint-disable-next-line max-len
      // Insert node at the end of the list if the index poits at the last list element
      this.append(data);
    } else {
      const newNode = new Node(data);
      const currentNode = this.getNodeByIndex(index);
      // The new Node's next pointer to be the current node
      newNode.next = currentNode;
      // Set the current previous pointer's next pointer to be the new node
      currentNode.prev.next=newNode;
      // The new node's previous pointer to be current node's previous pointer
      newNode.prev = currentNode.prev;
      // the current node's previous pointer to be the new node
      currentNode.prev = newNode;
    }
  };
  /**
   * Looks for the node at the specified index.
   * The list uses zero-based indexing
   * @param {Number} index
   * @return {Node} node
   */
  getNodeByIndex = (index) => {
    let node = this.head;
    let count = 0;
    while (node !== null && count!==index) {
      node = node.next;
      count += 1;
    }
    return node;
  };

  /**
   * Compute the length of the list. Number of nodes in the list
   * @return {Number}
   */
  size = () => {
    let node = this.head;
    let length = 0;
    while (node!==null) {
      length += 1;
      node = node.next;
    }
    return length;
  };
}

export default DoublyLinkedList;
