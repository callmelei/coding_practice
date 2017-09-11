class Solution {
    public int maxRotateFunction_bruteforce(int[] A) {
        /*
        brute force: iteration all index and value
        watch out the bondary
        time: O(n^2)
        space: O(1)
        17 / 17 test cases passed.
        Status: Accepted
        Runtime: 837 ms
        3.83%
        */
        int max = Integer.MIN_VALUE;
        int f = 0;
        int sum = 0;
        if (A.length == 0)
            return 0;
        for (int i = 0; i < A.length; i++) {
            sum = 0;
            for (int j = 0; j < A.length; j++){
                int index = -i + j;
                if (index < 0) index += A.length;
                sum += A[index]*(j);    
            }
            //System.out.println(sum);

            if (sum > max){
                max = sum;
                f = i;
            }
            
        }
        return max;
    }
    public int maxRotateFunction(int[] A) {
        /*mathametical
        
        [A,B,C,D,E]
        
              f(0) = 0A + 1B + 2C + 3D + 4E
     f(0)'=f(0)-sum= -1A + 0B + 1C + 2D + 3E
f(1) =f(0)-sum + 4A= 4A + 0B + 1C + 2D + 3E
        https://discuss.leetcode.com/topic/58616/java-solution-o-n-with-non-mathametical-explaination
        
        time: O(n)
        space: O(1)
        17 / 17 test cases passed.
        Status: Accepted
        Runtime: 5 ms
        23.63%
        */
        int sum = 0;
        int iteration = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            iteration += i*A[i];
        }
        max = iteration;
        
        for (int i = 1; i < A.length; i++) {
            iteration = iteration - sum + A[i-1] * (A.length);
            max = Math.max(max, iteration);
        }
        
        return max;
    }

}

/**/
