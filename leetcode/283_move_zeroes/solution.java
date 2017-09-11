
class Solution {
    public void moveZeroes(int[] nums) {
        /*
        two point:
        one points to numer in the slots
        ont points to the blank one
        
        21 / 21 test cases passed.
Status: Accepted
Runtime: 2 ms
59.38%
        */
        int curr_index = 0;
        
        if (nums == null || nums.length == 0) return;
        for (int num: nums) {
            if (num != 0) {
                nums[curr_index] = num;
                curr_index ++;
            }
        }
        for (int i = curr_index; i < nums.length; i++)
            nums[i] = 0;
        
    }
}
