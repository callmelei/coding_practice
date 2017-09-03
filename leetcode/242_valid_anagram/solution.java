class Solution {
    public boolean isAnagram(String s, String t) {
        /*
        34 / 34 test cases passed.
Status: Accepted
Runtime: 8 ms
32.08%
        */
        
        if (s.length() != t.length())
            return false;
        
        int [] hash = new int [256];
        
        for (int i = 0; i < 256; i++) {
            hash[i] = 0;
        }
        for (int i = 0 ; i < s.length(); i++) {
            hash[s.charAt(i)] ++;
        }
        
        int count = s.length();
        for (int i = 0; i < t.length(); i++) {
            if (hash[t.charAt(i)] >= 1) {
                count --;
            }
            hash[t.charAt(i)] --;
        }
        
        if (count == 0)
            return true;
        else
            return false;
        
    }
}
