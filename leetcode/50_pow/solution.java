class Solution {

    /*
       Q. n < 0
       */
    public double myPow_1(double x, int n) {
        /*TLE*/
        double result = 1;
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            result = 1/x;
            n ++;
            n = -n;
            x = 1/x;
        }
        else if (n < 0) {
            n = -n;
            x = 1/x;
        }
        for (int i = 0; i < n; i++)
            result *= x;

        return result;

    }
    public double myPow_stack(double x, int n) {
        /*TLE*/
        double result = 0;

        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        result = helper(x, n);
        //System.out.println(-3%2);
        return result;
    }
    public double helper(double x, int n) {

        //System.out.println(n);
        if (n == 1) return x;
        if (n == 0) return 1;

        if (n % 2 == 1)
            return helper(x, n/2) * helper(x, n/2) * helper(x, 1);
        else
            return helper(x, n/2) * helper(x, n/2);


    }
    double myPow(double x, int n) { 
        /*
           300 / 300 test cases passed.
Status: Accepted
Runtime: 20 ms
55.99%
*/
        double ans = 1;
        if(n==0) return 1;
        if (n == Integer.MIN_VALUE) {
            ans = 1/x;
            n ++;
            n = -n;
            x = 1/x;
        }
        else if(n<0) {
            n = -n;
            x = 1/x;
        }
        while(n>0){
            if(n % 2 == 1) ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
