class Solution {
    public int[] productExceptSelf(int[] nums) {
    /*two point:
        two rounds:
        1.start from left side, create a array which contains (1), (1)*a, (1)*a*b, (1)*a*b*c 
        2.start from right side, finish the array which is: (1)*b*c*d, (1)*a*c*d, (1)*a*b*d, (1)*a*b*c

        17 / 17 test cases passed.
        Status: Accepted
        Runtime: 2 ms
        29.42%
        time: O(n)
        space: O(1)
    */
        int tmp = 1;
        int [] ret = new int[nums.length];
        /*   ---->
        ix:  0 1     2          3
        val: 1 2     3          4
        ret: 1 1*1   1*1*2      1*1*2*3
        tmp: 1 1*1*2 1*1*2*3    1*1*2*3*4
        */
        for (int i = 0; i< nums.length; i++){
            ret[i] = tmp;
            tmp *= nums[i];
        }

        tmp = 1;
        /*    <-----------
        ix:  0                1           2                3
        val: 1                2           3                4
        ret: 1*1*4*3*2    1*1*1*4*3   1*1*2*1*4      1*1*2*3*1
        tmp: 1*1*4*3*2*1   1*4*3*2       1*4*3            1*4
        */
        for (int i = nums.length-1; i >= 0; i--) {
            ret[i] *= tmp;
            tmp *= nums[i];
        }

        //for (int i = 0; i < nums.length; i++) {
        //    System.out.println(ret[i]);
        //}
        return ret;
    }
}
