package com.algorithms.linkedlist.doubly;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.algorithms.linkedlist.Data;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {
  // Test Data
  Data[] data = { new Data(1, "Java"), new Data(2, "C#"), new Data(3, "Python"), new Data(4, "JavaScript"),
      new Data(5, "Ruby"), new Data(6, "GO"), new Data(7, "C++"), new Data(8, "C") };

  @Test
  void testAdd() {
    LinkedList<Data> list = new DoublyLinkedList<>();

    list.add(data[0]);

    assertEquals(null, list.getHead().getPrev());
    assertEquals(null, list.getHead().getNext());
    assertEquals(data[0], list.getHead().getData());
    assertEquals(1, list.size());

    list.add(data[1]);
    list.add(data[2]);
    list.add(data[3]);

    assertEquals(null, list.getHead().getPrev());
    assertEquals(data[2], list.getHead().getNext().getData());
    assertEquals(data[3], list.getHead().getData());
    assertEquals(4, list.size());

    assertEquals(null, list.getTail().getNext());
    assertEquals(data[0], list.getTail().getData());
    assertEquals(data[1], list.getTail().getPrev().getData());
  }

  @Test
  void testAppend() {
    LinkedList<Data> list = new DoublyLinkedList<>();

    list.append(data[0]);

    assertEquals(null, list.getHead().getPrev());
    assertEquals(null, list.getHead().getNext());
    assertEquals(data[0], list.getHead().getData());
    assertEquals(1, list.size());
    assertEquals(null, list.getTail().getPrev());
    assertEquals(null, list.getTail().getNext());
    assertEquals(data[0], list.getTail().getData());

    list.append(data[1]);
    list.append(data[2]);
    list.append(data[3]);

    assertEquals(data[2], list.getTail().getPrev().getData());
    assertEquals(data[3], list.getTail().getData());
    assertEquals(4, list.size());

    assertEquals(null, list.getTail().getNext());
  }

  @Test
  void testGetNodeByIndex() {
    LinkedList<Data> list = new DoublyLinkedList<>();

    list.add(data[0]);
    list.add(data[1]);
    list.add(data[2]);
    list.add(data[3]);
    assertEquals(list.getHead(), list.getNodeByIndex(0));
    assertEquals(list.getTail(), list.getNodeByIndex(3));
    assertEquals(list.getHead().getNext(), list.getNodeByIndex(1));
  }

  @Test
  void testGetNodeIndex() {
    LinkedList<Data> list = new DoublyLinkedList<>();

    list.add(data[0]);
    list.add(data[1]);
    list.add(data[2]);
    list.add(data[3]);
    assertEquals(0, list.getNodeIndex(data[3]));
    assertEquals(3, list.getNodeIndex(data[0]));
    assertEquals(1, list.getNodeIndex(data[2]));
    assertEquals(-1, list.getNodeIndex(data[4]));
  }

  @Test
  void testInsert() {
    LinkedList<Data> list = new DoublyLinkedList<>();

    list.insert(0, data[0]);
    list.insert(0, data[1]);
    list.insert(1, data[2]);
    list.insert(2, data[3]);
    assertEquals(4, list.size());
  }

  @Test
  void testIsEmpty() {

  }

  @Test
  void testPop() {

  }

  @Test
  void testRemove() {

  }

  @Test
  void testRemove2() {

  }

  @Test
  void testRemove3() {

  }
}
