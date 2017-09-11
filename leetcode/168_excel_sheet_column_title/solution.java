class Solution {
    public String convertToTitle_stringbuilder(int n) {
        /*
        18 / 18 test cases passed.
Status: Accepted
Runtime: 0 ms
        */

        int m = 0;
        StringBuilder result = new StringBuilder();

        
        if (n <= 0)
            return ""; 
        while (n > 0) {
            n --; /*key, since we don't have 0, we need to start with 1, */
            m = n % 26; 
            n = n / 26;
            result.insert(0, (char) ('A' + m)); 
        }
        
        return result.toString();
        
    }
    public String convertToTitle(int n) {
        /*
        18 / 18 test cases passed.
Status: Accepted
Runtime: 0 ms
        */

        int m = 0;
        StringBuilder result = new StringBuilder();

        
        if (n <= 0)
            return ""; 
        while (n > 0) {
            n --; /*key, since we don't have 0, we need to start with 1, */
            m = n % 26; 
            n = n / 26;
            result.append((char) ('A' + m)); 
        }
        result.reverse();
        return result.toString();
        
    }
    
    public String convertToTitle_string(int n) {
        /*
        18 / 18 test cases passed.
Status: Accepted
Runtime: 0 ms
        */
        String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ans = "";
        int m = 0;

        
        if (n <= 0)
            return ""; 
        while (n > 0) {
            n --; /*key, since we don't have 0, we need to start with 1, */
            m = n % 26; 
            n = n / 26;
            ans = map.charAt(m) + ans;
        }
        
        return ans;
        
    }
    
}
