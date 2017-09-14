class Solution {
    public boolean isPowerOfThree_iterative(int n) {
        /*
        
        iterative:
        loop:
        math:
        https://discuss.leetcode.com/topic/33536/a-summary-of-all-solutions-new-method-included-at-15-30pm-jan-8th/5
        21038 / 21038 test cases passed.
Status: Accepted
Runtime: 18 ms
61.41%
        */
        
        int m;
        if (n <= 0)
            return false;
        while (n != 1){
            m = n % 3;
            if (m != 0) 
                return false;
            else
                n = n/3;
        }
        return true;  
    }
    public boolean isPowerOfThree(int n) {
        /*
        21038 / 21038 test cases passed.
Status: Accepted
Runtime: 17 ms
86%
        */
        return (n > 0 && 1162261467 % n == 0);
    }

}
