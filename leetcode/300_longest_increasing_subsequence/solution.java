class Solution {
 
    public int lengthOfLIS_dp_n2(int[] nums) {
           /*
    24 / 24 test cases passed.
Status: Accepted
Runtime: 33 ms
27.05%
time: O(n^2)
space: O(n)
    */
        if (nums.length == 0) {    
            return 0;
        }
        int [] dp = new int[nums.length];
        int max_length_per_round = Integer.MIN_VALUE;
        int max_length_result = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i ++){
            dp[i] = 0;
        }
        for (int x = 0; x < nums.length; x ++){
            max_length_per_round = 0;
            for (int y = x-1; y >= 0; y --){
                if (nums[x] > nums[y]){
                    max_length_per_round = Math.max(max_length_per_round, dp[y]);
                    //System.out.printf("%d, %d\n",nums[y], nums[x]);
                }
                
            }
            dp[x] = max_length_per_round + 1;
            max_length_result = Math.max(max_length_result, dp[x]);
        }
        
        return max_length_result;
    }
    public int lengthOfLIS(int[] nums) {
        /*
        24 / 24 test cases passed.
Status: Accepted
Runtime: 2 ms
74.08%
https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation
time: O(nlongn)
space: O(n)
        */
        if (nums.length == 0) {    
            return 0;
        }
        int [] dp = new int[nums.length];
        int len = 0;
        int index;
        for (int num: nums){
            index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) index = - (index+1);
            dp[index] = num;
            if (index == len) len++;
            
        }
        
        return len;
    }
}
