class MaximumSubArray{
  constructor(arr) {
    this.data = arr; //creates a data of array elements
  }

  maximumSubArrayBrutforce() {
    let n = this.data.length,
        maxSum = 0,
        indexRange = [0,0];

    for (let i =0; i < n; i += 1) {
      let localSum = 0;
      for (let j = i; j < n; j += 1) {
        localSum += this.data[j];
        console.log(i,':',j,':::',localSum,'--',maxSum);
        if (localSum > maxSum){
          maxSum = localSum;
          indexRange[0] = i;
          indexRange[1] = j;
        }
      }
    }
    return {
      indexRange,
      maxSum
    };
  }
}

const arr = [-3, -1, 0, 5, -2, 1, -5, 8, 6, 4, -4, 3];
const m = new MaximumSubArray(arr);
console.log(m.maximumSubArrayBrutforce().indexRange, ':', m.maximumSubArrayBrutforce().maxSum);
