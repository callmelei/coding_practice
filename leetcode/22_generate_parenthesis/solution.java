class Solution {
    List <String> ans = new LinkedList<String>();

    public List<String> generateParenthesis_my(int n) {
    /*
    8 / 8 test cases passed.
Status: Accepted
Runtime: 7 ms
10.89%
    */        
        
        helper("", n);
        return ans;
    }
    public void process_ans(String temp) {
        ans.add(temp);
    }
    public void helper(String temp, int count) {
        if (temp.length() >= count*2) {
            process_ans(temp);
        }else {
            String cand = build_cand(temp, count);
            for (int i = 0; i < cand.length(); i++) {
                helper(temp + cand.charAt(i), count);
            }
            
        }
    }
    public String build_cand(String temp, int count) {
        int left = 0;
        int right = 0;
        String cand = "";
        for (int i = 0; i < temp.length(); i++) {   
            if (temp.charAt(i) == '(')
                left ++;
            if (temp.charAt(i) == ')')
                right ++;
        }
        if (left < count)
            cand += "(";
        if (right < count && left > right)
            cand += ")";
        return cand;
    }
    
    
    public List<String> generateParenthesis(int n) {
        /*
        8 / 8 test cases passed.
Status: Accepted
Runtime: 4 ms
22.23%
        */
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
