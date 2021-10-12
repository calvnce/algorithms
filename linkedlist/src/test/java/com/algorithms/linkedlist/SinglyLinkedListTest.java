package com.algorithms.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
  // Sample test data
  Data data[] = { new Data(1, "Introduction To Algorithms"), new Data(2, "Advanced Algorithms"),
      new Data(3, "Dynamic Programming"), new Data(4, "Object Oriented Programming"),
      new Data(5, "Functional Programming") };

  @Test
  void testAdd() {
    SinglyLinkedList list = new SinglyLinkedList();
    list.add(new Node(data[0]));
    list.add(new Node(data[1]));
    list.add(new Node(data[2]));
    list.add(new Node(data[3]));
    list.add(new Node(data[4]));

    assertEquals(1, list.getTail().getData().getId());
    assertEquals(5, list.getHead().getData().getId());
  }

  @Test
  void testAppend() {
    SinglyLinkedList list = new SinglyLinkedList();
    list.append(new Node(data[0]));
    list.append(new Node(data[1]));
    list.append(new Node(data[2]));
    list.append(new Node(data[3]));
    list.append(new Node(data[4]));

    assertEquals(5, list.getTail().getData().getId());
    assertEquals(1, list.getHead().getData().getId());
  }

  @Test
  void testInsert() {
    SinglyLinkedList list = new SinglyLinkedList();
    list.insert(new Node(data[0]), 0);
    list.insert(new Node(data[1]), 0);
    list.insert(new Node(data[2]), 1);
    list.insert(new Node(data[3]), 0);
    list.insert(new Node(data[4]), 3);

    assertEquals(1, list.getTail().getData().getId());
    assertEquals(4, list.getHead().getData().getId());
  }

  @Test
  void testSize() {
    SinglyLinkedList list = new SinglyLinkedList();
    list.add(new Node(data[3]));
    list.add(new Node(data[4]));
    list.append(new Node(data[1]));
    list.append(new Node(data[2]));
    list.insert(new Node(data[0]), 0);
    list.insert(new Node(data[1]), 0);
    list.insert(new Node(data[2]), 1);
    list.insert(new Node(data[3]), 0);
    list.insert(new Node(data[4]), 3);

    assertEquals(9, list.size());
  }

  @Test
  void testPop() {
    SinglyLinkedList list = new SinglyLinkedList();
    list.append(new Node(data[0]));
    list.append(new Node(data[1]));
    list.append(new Node(data[2]));
    list.append(new Node(data[3]));
    list.append(new Node(data[4]));

    list.pop();
    list.pop();
    list.append(new Node(data[3]));
    list.append(new Node(data[4]));

    assertEquals(5, list.getTail().getData().getId());
    assertEquals(1, list.getHead().getData().getId());
  }

  @Test
  void testRemoveFront() {
    SinglyLinkedList list = new SinglyLinkedList();
    list.add(new Node(data[0]));
    list.add(new Node(data[1]));
    list.add(new Node(data[2]));
    list.add(new Node(data[3]));
    list.add(new Node(data[4]));

    list.remove();
    list.remove();
    list.append(new Node(data[3]));
    list.append(new Node(data[4]));

    assertEquals(5, list.getTail().getData().getId());
    assertEquals(3, list.getHead().getData().getId());
  }

  @Test
  void testRemoveByIndex() {
    SinglyLinkedList list = new SinglyLinkedList();
    list.insert(new Node(data[0]), 0);
    list.insert(new Node(data[1]), 0);
    list.insert(new Node(data[2]), 1);
    list.insert(new Node(data[3]), 0);
    list.insert(new Node(data[4]), 3);

    list.remove(2);
    list.remove(3);

    assertEquals(3, list.size());

    list.add(new Node(data[3]));
    list.add(new Node(data[4]));

    assertEquals(5, list.getTail().getData().getId());
    assertEquals(5, list.getHead().getData().getId());
  }

  @Test
  void testRemoveByNode() {
    SinglyLinkedList list = new SinglyLinkedList();
    list.insert(new Node(data[0]), 0);
    list.insert(new Node(data[1]), 0);
    list.insert(new Node(data[2]), 1);
    list.insert(new Node(data[3]), 0);
    list.insert(new Node(data[4]), 3);

    list.remove(new Node(data[2]));
    list.remove(new Node(data[0]));
    list.remove(new Node(data[4]));

    assertEquals(2, list.getTail().getData().getId());
    assertEquals(4, list.getHead().getData().getId());
  }
}
