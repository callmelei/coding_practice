class Solution {
    public boolean checkValidString(String s) {
        /*
        https://discuss.leetcode.com/topic/103948/java-12-lines-solution-backtracking
        backtracking
        when taking care of single char pair issues
        just use a counter to count the pair dynamically.
        '('->count ++
        ')'->count --
        if there is a wild characters, it can use backtrack philosophy, just run into different possiblities
        and find the answers.
        
        it's different from the 20 valid Parenthesis, in that question, there are three types of parenthesis
        we cannot just count the numbers directly.
        
        time: O(n^3)
        space: O(1)
        58 / 58 test cases passed.
        Status: Accepted
        Runtime: 587 ms
        7.91%
        */
        
        if (s.length() == 0) 
            return true;
        
        return check(s, 0, 0);
    }
    public boolean check(String s, int index, int count) {
        
        if (index == s.length()) {
            if (count == 0)
                return true;
            else
                return false;
        }
        if (s.charAt(index) == '(')
            count ++;
        else if (s.charAt(index) == ')') {
            count --;
            if (count < 0)
                return false;
        }else if (s.charAt(index) == '*') {
            
            return check(s, index+1, count+1) | check(s, index+1, count-1) | check(s, index+1, count);
        }
        return check(s, index+1, count);
        
    }
}
