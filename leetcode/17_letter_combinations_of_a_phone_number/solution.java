class Solution {
    List<String> ret = new ArrayList<>();
    String [] map = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations_recursive(String digits) {
        /*
        25 / 25 test cases passed.
        Status: Accepted
        Runtime: 5 ms
        11.95%
        recursive way
        */
        if (digits.length() == 0)
            return ret;
        
        helper("", 0, digits);
        
        return ret;
    }
    public void helper(String word, int index, String digits) {
        
        if (word.length() >= (digits.length())) {
            ret.add(word);  
            return;
        }
        
        for (int i = index; i < digits.length(); i++) {
            //System.out.println(digits.charAt(i));
            String letters = new String (map[digits.charAt(i)-'1']);
            //System.out.println(letters);
            //System.out.println(index);
            //System.out.println(word);
            for (int j = 0; j < letters.length(); j++) {
                String newWord = new String();
                newWord = word + letters.charAt(j);
                helper(newWord, i+1, digits);
            }
            
        }
        return;
    }
    
    public List<String> letterCombinations(String digits) {

    /*
    iterative way
    25 / 25 test cases passed.
    Status: Accepted
    Runtime: 4 ms
    30%
    */  LinkedList<String> ans = new LinkedList<String>();
        
        if (digits.length() == 0)
            return ans;
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = digits.charAt(i)-'1';
            while(ans.peek().length() == i) {
                String str = ans.remove();
                for (char ch: map[x].toCharArray()) {
                    ans.add(str + ch);
                    
                }
                
            }
        }
        return ans;
    }
}
