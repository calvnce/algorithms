class Sort {
  constructor() {
    this.data = [];
    this.t =0;

    //populates the sample array with random data
    for (let index = 0; index < 105; index++) {
      this.data.push(Math.floor((Math.random() * 100) + 1));
    }
  }

  /**
   * This method performs an insertion sort on the provided array.
   * Input:
   *      inputArr
   * Output:
   *      None
   */
  insertion () {
    for (let j = 0; j < this.data.length; j++) {
      /*The next element to be compared in the array */
      const key = this.data[j];

      /*The previous element in the array */
      let i = j - 1;

      /*Chek through the array to see if all previous elements are greater than the curent lement [key] */
      while (i > -1 && this.data[i] > key) {
        his.data[i + 1] = this.data[i];
        i -= 1;
      }
      /*Insert the element at the appropriate position within the array */
      this.data[i + 1] = key;
    }
  }

  merge (A, startIndex, middleIndex, endIndex) {
    const subArrayASize = middleIndex - startIndex + 1;
    const subArrayBSize = endIndex - middleIndex;
    const subArrayA = [];
    const subArrayB = [];
    let mainArrayIndex = startIndex; //tracks the indices of the main Array
    let subArrayAIndex = 0 //tracks the indices of the subArrayA
    let subArrayBIndex = 0; //tracks the indices of the subArrayA


    ///Fill the sub-arrays with the appriate values based on the indices
    for (let index = 0; index < endIndex; index += 1) {
      subArrayA.push(A[startIndex + index]);
    }

    for (let index = 0; index < subArrayBSize; index += 1) {
      subArrayB.push(A[middleIndex + index + 1]);
    }

    for (mainArrayIndex; mainArrayIndex < endIndex+1; mainArrayIndex += 1) {
      if (subArrayAIndex >= subArrayASize || subArrayBIndex >= subArrayBSize){
        subArrayAIndex < subArrayASize ? A[mainArrayIndex] = subArrayA[subArrayAIndex] : A[mainArrayIndex]=subArrayB[subArrayBIndex];
        subArrayAIndex += 1;
        subArrayBIndex += 1;
      }
      else {
        if (subArrayA[subArrayAIndex] <= subArrayB[subArrayBIndex]) {
          // A[mainArrayIndex] = subArrayA[subArrayAIndex];
          A[mainArrayIndex] = subArrayA[subArrayAIndex];
          subArrayAIndex += 1;
        }
        else {
          // A[mainArrayIndex] = subArrayB[subArrayBIndex];
          A[mainArrayIndex] = subArrayB[subArrayBIndex];
          subArrayBIndex += 1;
        }
      }
    }
  }
  
  mergeSort(A, startIndex, endIndex) {
    if (startIndex < endIndex) {
      const middleIndex = Math.floor((startIndex + endIndex) / 2);

      this.mergeSort(A, startIndex, middleIndex);
      this.mergeSort(A, middleIndex + 1, endIndex);
      this.merge(A, startIndex, middleIndex, endIndex);
    }
  }
}

const sort = new Sort();
