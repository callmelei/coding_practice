class Solution {
    public boolean search(int[] nums, int target) {
        /*
        handle the duplicated number by checking nums[mid] and nums[right] or nums[mid] and nums[left]
        binary search
        273 / 273 test cases passed.
Status: Accepted
Runtime: 1 ms
10%
        */
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        
        if (nums.length == 0 || nums == null)
            return false;
        while (left + 1 < right) {
            mid = (left + right) /2 ;
            
            if (nums[mid] == target) 
                return true;
            
            if (nums[left] < nums[mid]) {
               if (target >= nums[left] && target <= nums[mid])
                   right = mid;
                else
                    left = mid;
            } else if (nums[left] == nums[mid])
                left ++;
            if (nums[right] > nums[mid]) {
                if (target >= nums[mid] && target <= nums[right])
                    left = mid;
                else
                    right = mid;
            }else if (nums[right] == nums[mid])
                right --;
        }
        
        if (target == nums[left]) return true;
        if (target == nums[right]) return true;
        
        return false;
        
    }
}
