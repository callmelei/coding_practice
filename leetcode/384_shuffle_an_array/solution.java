import java.util.Random;

class Solution {
    
    private int [] nums;
    private Random random;
    public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int [] a = this.nums.clone();
        
        for (int i = 0; i < a.length; i++) {
            int j = random.nextInt(i+1);
            int swp = a[i];
            a[i] = a[j];
            a[j] = swp;
        }
        return a;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
