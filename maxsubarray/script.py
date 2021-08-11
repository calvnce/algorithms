class MaximumSubArray:
  def __init__(self, arr) -> None:
    self.data = arr
    pass

  def brutforceFindMaximumSubArray(self):
    '''
      One very obvious but not so good solution is to calculate the sum of every 
      possible subarray and the maximum of those would be the solution. 
      
      We can start from index 0 and calculate the sum of every possible 
      subarray starting with the element data[0]. Then, we would calculate the sum of every 
      possible subarray starting with data[1], data[2] and so on up to data[n-1], 
      where n denotes the size of the array

      We will call the maximum sum of subarrays starting with element data[i] the current_maximum at index i. 
      Thus after going through all the indices, we would be left with current_maximum for all the indices. 
      Finally, we can find the maximum of these local_maximums and we would get the final solution, 
      i.e. the maximum sum possible. We would call this the best_maximum.

      Runtime: O(n^2)
    '''
    n = len(self.data)
    best_maximum = float('-inf')
    for i in range(n):
      current_maximum = 0
      for k in range(i,n):
        current_maximum += self.data[k]
        if current_maximum > best_maximum:
          best_maximum = current_maximum
          low = i
          high = k
    return ([low, high], best_maximum)


  def iterativeFindMaximumSubarray(self):
    """
    Kadane's original algorithm solves the problem version when empty subarrays are admitted. 
    It scans the given array data[1...n] from left to right. In the ith step, it computes the subarray with the largest sum ending at i; 
    this sum is maintained in variable current_sum. Moreover, it computes the subarray with the 
    largest sum anywhere in data[1 ..i], maintained in variable best_sum, and easily obtained 
    as the maximum of all values of current_sum.

    Runtime : O(n)
    """
    startIndex = endIndex = 0
    best_maximum = float('-inf')
    current_maximum = 0

    for current_index_end, val in enumerate(self.data):
      if current_maximum <= 0:
         # Start a new sequence at the current element
        current_index_start = current_index_end
        current_maximum = val
      else:
        #adjust the existing current sum with the next value in the sequence
        current_maximum += val

      if current_maximum > best_maximum:
        best_maximum = current_maximum
        startIndex = current_index_start
        endIndex = current_index_end #makes the index exclisive

    return ([startIndex,endIndex],best_maximum)



if __name__ == '__main__':
  sample_data = [-3,-1,0,5,-2,1,-5,8,6,4,-10]
  maxsub = MaximumSubArray(sample_data)

  #using brutforce
  index_range, maxsum = maxsub.brutforceFindMaximumSubArray()
  print(index_range,maxsum)

  #using Kadane's Algorithm
  index_range, maxsum = maxsub.iterativeFindMaximumSubarray()
  print(index_range,maxsum)