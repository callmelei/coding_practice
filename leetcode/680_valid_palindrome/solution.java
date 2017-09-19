class Solution {
    public boolean validPalindrome_twoloop(String s) {
        int left = 0;
        int right = s.length()-1;
        int count = 0;
        int fail_count = 0;
        
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            }else if (s.charAt(left+1) == s.charAt(right)) {
                    left += 2;
                    right --;
                    count ++;
            }else if (s.charAt(left) == s.charAt(right-1)){
                left ++;
                right -= 2;
                count ++;
            } else {
                fail_count ++;
                break;
            }
            if (count >= 2) {
                fail_count++;
                break;
            }
        }
        if (left >= right && fail_count==0)
            return true;
        count = 0;
        left = 0;
        right = s.length() -1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            }else if (s.charAt(left) == s.charAt(right-1)){
                left ++;
                right -= 2;
                count ++;
            } else if (s.charAt(left+1) == s.charAt(right)) {
                    left += 2;
                    right --;
                    count ++;
            } else {
                fail_count ++;
                break;
            }
            if (count >= 2) {
                fail_count ++;
                break;
            }
        }
            
        if (fail_count == 2)
            return false;
        else
            return true;
    }
    
    public boolean validPalindrome(String s) {
        /*
        460 / 460 test cases passed.
        Status: Accepted
        Runtime: 37 ms
        88.63%
        */
        int left = 0; 
        int right = s.length()-1;
        
        while (left < right) {
            
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            }else {
                return (isValidPalindrome(s, left + 1, right) || isValidPalindrome(s, left, right-1));
            }
             
        }
        return true;
        
    }
    public boolean isValidPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            }else
                return false;
        }
        return true;
    }
}
