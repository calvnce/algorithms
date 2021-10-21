package com.algorithms.linkedlist.doubly;

public interface LinkedList<T> {
  void add(T data);

  void append(T data);

  void insert(int index, T data);

  Node<T> pop();

  Node<T> remove();

  Node<T> remove(int index);

  Node<T> getNodeByIndex(int index);

  int getNodeIndex(T data);

  void display();

  int size();

  boolean isEmpty();

  Node<T> getHead();

  Node<T> getTail();
}
