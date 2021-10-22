import Data from '../src/data.js';
import list from '../src/linkedlist.js';
import assert from 'assert';


// Test data
const data =[
  new Data(1, 'Calvo Johns', 25),
  new Data(2, 'Ann Alice', 21),
  new Data(3, 'Steve Jobs', 50),
  new Data(4, 'Karim Benzea,', 44),
];


describe('DoublyLinkedList', () => {
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
      assert.equal(list.size(), 5);
    });
  });
});
