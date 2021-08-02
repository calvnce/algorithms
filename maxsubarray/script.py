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

      We will call the maximum sum of subarrays starting with element data[i] the local_maximum at index i. 
      Thus after going through all the indices, we would be left with local_maximum for all the indices. 
      Finally, we can find the maximum of these local_maximums and we would get the final solution, 
      i.e. the maximum sum possible. We would call this the global_maximum.
    '''
    n = len(self.data)
    global_maximum = 0
    for i in range(n):
      local_maximum = 0
      for k in range(i,n):
        local_maximum += self.data[k]
        if local_maximum > global_maximum:
          global_maximum = local_maximum
          low = i
          high = k
    return ([low, high], global_maximum)

if __name__ == '__main__':
  sample_data = [-3,-1,0,5,-2,1,-5,8,6,4,-10]
  maxsub = MaximumSubArray(sample_data)

  #using brutforce
  index_range, maxsum = maxsub.brutforceFindMaximumSubArray()
  print(index_range,maxsum)

