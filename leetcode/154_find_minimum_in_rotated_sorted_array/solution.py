class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        """
        when we need to locate the minimum value, it means we need to use binary search
       classical binary search can only handle non-duplicated elements
       if we want to handle the duplicated elements, 
       we need to move the right line when nums[mid] == nums[right]
       testcase: 
       [8, 8, 8, 8, 8, 7, 8]
       [8, 7, 8, 8, 8, 8, 8]
       
       192 / 192 test cases passed.
       Status: Accepted
       Runtime: 35 ms
       80.43%
        """
        left = 0
        right = len(nums)-1
        mid = int((left+right)/2)       
        while left < right:
            #print left, mid, right
            if nums[mid]<nums[mid-1]: # it means we meet the pivot point, the minimum value is found
                break
            elif nums[mid] > nums[right]: # 7 8 9 1 2 3 4, the pivot point is in the right side
                left = mid+1
            elif nums[mid] < nums[right]:
                right = mid                # 8 8 8 8 8 7 8 , the pivot point is in the  left side
            else: # handle nums[mid] == nums[right], move the right line until we have smaller or larger value
                right = right - 1
            mid = int((left+right)/2)
        
       # print nums[mid]
        #print mid
        return nums[mid]
            
            
