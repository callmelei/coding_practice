
class Solution {
    public int firstUniqChar(String s) {
        /*
        Q. do we have empty string?
        A. just return -1
        Q. do we have capital letters?
        A. no, we only have lowercase  letters
        104 / 104 test cases passed.
Status: Accepted
Runtime: 24 ms
81.81%
        */
        int [] hash = new int[256];
        
        int n = s.length();
        if (n == 0)
            return -1;
        
        for (int i = 0; i < 256; i++) {
            hash[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            hash[s.charAt(i)] ++;
            
        }
        
        for (int i= 0; i < n; i++) {
            if (hash[s.charAt(i)] == 1)
                return i;
            
        }
        return -1;
    }
}
