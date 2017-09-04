

class Solution {
    public int[] findErrorNums_n(int[] nums) {
        /*
        49 / 49 test cases passed.
Status: Accepted
Runtime: 9 ms
82.85%
time:o(n)
space:o(n)
        */
        int [] result = new int[2];        
        int [] hash = new int [nums.length+1];
        for (int i = 0; i < hash.length; i ++) {
            hash[i] = 0;
        }
        for (int i = 0; i < nums.length; i ++) {
            hash[nums[i]] ++;
        }
        for (int i = 1; i <= nums.length; i ++) {
            if (hash[i] == 0) 
                result[1] = i;
            if (hash[i] == 2)
                result[0] = i;
        }
        
 
        
        return result;
    }
    public int[] findErrorNums(int[] nums) {
        /*
        49 / 49 test cases passed.
Status: Accepted
Runtime: 13 ms
53.50%
time:o(n)
space:o(1)
        */
        int [] result = new int [2];
        
        for (int i = 0; i < nums.length; i ++){
            if (nums[Math.abs(nums[i])-1] < 0) result[0] = Math.abs(nums[i]);
            else nums[Math.abs(nums[i])-1] *= -1;
        }
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] > 0) result[1] = i+1;
        }
        return result;
    }
}
