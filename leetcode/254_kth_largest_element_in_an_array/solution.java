import java.util.Arrays;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*is it a unique array?*/
        /*time: O(nlogn)
	  space: O(1)
	*/
        Arrays.sort(nums);

        return nums[nums.length-(k)];

    }
}
