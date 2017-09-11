class Solution {
    public String countAndSay(int n) {
        /*
        18 / 18 test cases passed.
Status: Accepted
Runtime: 38 ms
9%
        */
        String input = "1";
        String immediate_str = "";

        
        for (int i = 1; i < n; i++) {
            //System.out.println(input);
            char [] nums = input.toCharArray();
            int count = 0;
            int prev = -1;
            for (int j = 0; j < nums.length; j++) {
                //System.out.println(j + ","+ nums[j]);
                if ((nums[j] - '0') == prev) {
                    count ++;
                }
                else {
                    if (prev != -1)
                        immediate_str += Integer.toString(count) + Integer.toString(prev);
                    count = 1;
                }
                prev = nums[j] - '0';
            }
            immediate_str += Integer.toString(count) + Integer.toString(prev);
            input = immediate_str;
            immediate_str = "";
        }
     return input;   
    }
}
