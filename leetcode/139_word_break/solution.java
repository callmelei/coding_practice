class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        34 / 34 test cases passed.
Status: Accepted
Runtime: 16 ms
47.45%
        */
        int []dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            dp[i] =-1;
        }
        return canBreak(0, s, wordDict, dp);
    }
    public boolean canBreak(int start, String s, List<String> wordDict, int[] dp) {
        if (start == s.length())
            return true;

        if (dp[start] == 1) return true;
        else if (dp[start] == 0) return false;
        /*when it enters recursively, it should be memoried*/
        for (int end = start + 1; end <= s.length(); end ++) {
            //System.out.println(s.substring(start,end));
            if (wordDict.contains(s.substring(start, end)) && canBreak(end, s, wordDict, dp) ) {
                dp[start] = 1;
                return true;
            }
        }
        dp[start] = 0;
        return false;
    }
}
