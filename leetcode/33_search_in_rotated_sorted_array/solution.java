class Solution {
    public int search(int[] nums, int target) {
        /*
        because the sequence will have at lease one order half.
        try to search in the half if the number is in the half otherwise search the other half.
        binary search
        196 / 196 test cases passed.
Status: Accepted
Runtime: 16 ms
19%
        */
        
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        
        if (nums.length == 0) return -1;
        while (left + 1 < right) {
            mid = (left + right )/ 2;
            
            if (target == nums[mid])
                return mid;
            
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid])
                    right = mid;
                else
                    left = mid;
                
            }
            if (nums[mid] <= nums[right]) {
                if (target <= nums[right] && target >= nums[mid])
                    left = mid;
                else
                    right = mid;
                
            }
        }
        
        if (target == nums[left]) return left;
        if (target == nums[right]) return right;
        
        return -1;
        
    }
}
