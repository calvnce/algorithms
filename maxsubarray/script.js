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

  maxCrossingSubArray(A, low, mid, high) {
    let bestSumBelowMidArray = -Number.MAX_SAFE_INTEGER,
        bestSumAboveMidArray = -Number.MAX_SAFE_INTEGER;
    let belowMidMaxIndex = 0,
        aboveMidMaxIndex = 0;

    let currentSum = 0;

    for (let index = mid; index >= low; index -= 1) {
      currentSum += A[index];
      if(currentSum > bestSumBelowMidArray){
        bestSumBelowMidArray = currentSum;
        belowMidMaxIndex = index;
      }
    }

    currentSum = 0;
    for (let index = mid + 1; index <= high; index += 1) {
      currentSum += A[index];;
      if(currentSum > bestSumAboveMidArray){
        bestSumAboveMidArray = currentSum;
        aboveMidMaxIndex = index;
      }
    }

    return [belowMidMaxIndex,aboveMidMaxIndex, (bestSumBelowMidArray + bestSumAboveMidArray)];
  }

  recurviveMaxSubArray(A,low,high) {
    if (low === high){
      return [low, high, A[low]];
    }
    else {
      let mid = Math.floor((low + high) / 2);
      const subArrayBelow = this.recurviveMaxSubArray(A,low,mid);
      const subArrayAbove = this.recurviveMaxSubArray(A, mid + 1, high);
      const subArrayCrossMid = this.maxCrossingSubArray(A, low, mid, high);

      if (subArrayBelow[2] >= subArrayAbove[2] && subArrayBelow[2] >= subArrayCrossMid[2]){
        return subArrayBelow;
      }
      else if (subArrayAbove[2] >= subArrayBelow[2] && subArrayAbove[2] >= subArrayCrossMid[2]) {
        return subArrayAbove;
      }
      else {
        return subArrayCrossMid;
      }
    }
  }
}