/**
 * This class is a reprsentation of the data consumed
 * by the linked list data structure
 */
class Data {
  /**
   * This constructor initializes the data properties
   * @param {Number} id
   * @param {string} name
   * @param {Number} age
   */
  constructor(id, name, age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  /**
   * Get the ID property
   * @return {Number}
   */
  getId = () =>this.id;

  /**
   * Get the name property
   * @return {string}
   */
  getName = () =>this.name;

  /**
   * Get the age property
   * @return {string}
   */
  getAge = () =>this.age;
}

export default Data;
