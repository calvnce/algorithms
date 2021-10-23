import Data from '../src/data.js';
import DoublyLinkedList from '../src/linkedlist.js';
import assert from 'assert';

// Test data
const data =[
  new Data(1, 'Calvo Johns', 25),
  new Data(2, 'Ann Alice', 21),
  new Data(3, 'Steve Jobs', 50),
  new Data(4, 'Karim Benzea,', 44),
];


describe('DoublyLinkedList', () => {
  let list = new DoublyLinkedList();

  it('should return 0 when the list is empty', () => {
    assert.equal(list.size(), 0);
  });

  describe('add(data)', () => {
    it('should add node without error', () => {
      list.add(data[0]);
      list.add(data[1]);
      list.add(data[2]);
      assert.equal(list.size(), 3);
    });
  });

  describe('append(data)', () => {
    it('should append node without error', () => {
      list.append(data[3]);
      list.append(data[4]);
      assert.equal(5, list.size());
      assert.equal(data[2], list.head.data);
      assert.equal(data[4], list.tail.data);
    });
  });

  describe('insert(data)', () => {
    it('should insert node at the specified index without error', () => {
      list = new DoublyLinkedList();

      list.add(data[1]);
      list.add(data[2]);
      list.append(data[3]);
      list.append(data[4]);
      list.insert(2, data[0]);

      assert.equal(5, list.size());
      assert.equal(data[0], list.getNodeByIndex(2).data);
      assert.equal(data[3], list.getNodeByIndex(3).data);
    });
  });
});
