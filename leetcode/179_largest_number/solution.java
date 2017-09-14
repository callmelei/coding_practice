class Solution {
    public String largestNumber(int[] nums) {
      /*
      backtracking(brute force):
      list all combinations and find the maximum
      n!
      the iterations can be reduced by remove the smaller one 
      
      however, it takes time to solve it by backtracking
      */  
      /*
      a better way is to sort the string by the digits
      so, it needs to write a custom sorting function for string
      
      221 / 221 test cases passed.
Status: Accepted
Runtime: 117 ms
69%
      */
      
        String []str_num = new String[nums.length];
      
        if (nums.length == 0 || nums == null)
            return "0";
        for (int i = 0; i < nums.length; i++) {
            str_num[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> comp = new Comparator<String> (){
            public int compare(String s1, String s2) {
               // @Override
                String str1 = s1+s2;
                String str2 = s2+s1;
                
                return str2.compareTo(str1);
            }
            
        };
        
        Arrays.sort(str_num, comp);
        if (str_num[0].charAt(0) == '0')
            return "0";
        StringBuilder ans = new StringBuilder();
        
        for (String str: str_num)
            ans.append(str);
        return ans.toString();
        
    }
}
