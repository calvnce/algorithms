class MaximumSubArray{
  constructor(arr) {
    this.data = arr; //creates a data of array elements
  }

  maximumSubArrayBrutforce() {
    let n = this.data.length,
        betSum = 0,
        indexRange = [0,0];

    for (let i =0; i < n; i += 1) {
      let currentSum = 0;
      for (let j = i; j < n; j += 1) {
        currentSum += this.data[j];
        if (currentSum > betSum){
          betSum = currentSum;
          indexRange[0] = i;
          indexRange[1] = j;
        }
      }
    }
    return {
      indexRange,
      betSum
    };
  }

  maximumSubArrayIterative() {
    let curretSum =0,
        bestSum = -Number.MAX_VALUE,
        indexRange =[0,0];
    
    for (let i = 0; i < this.data.length; i +=1) {
      if (curretSum <= 0) {
        indexRange[0] = i;
        curretSum = this.data[i];
      }else {
        curretSum += this.data[i];
      }

      if (curretSum > bestSum) {
        bestSum = curretSum;
        indexRange[1] = i;
      }
    }
    return {
      indexRange,
      bestSum
    }
  }

  maximumSubArrayKadane() {
    let bestSum = -Number.MAX_VALUE,
        curretSum = 0;
        
    for (let index = 0; index < this.data.length; index++) {
      curretSum = Math.max(0, curretSum+this.data[index]);
      bestSum = Math.max(bestSum, curretSum);
    }
    return bestSum;
  }
}