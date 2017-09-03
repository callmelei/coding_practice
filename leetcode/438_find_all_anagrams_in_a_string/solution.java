class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /*
        36 / 36 test cases passed.
	Status: Accepted
	Runtime: 26 ms
    	47.45%
        */
        int [] hash = new int[256];
        for (int i = 0; i < hash.length; i ++){
            hash[i] = 0;
        }
        
        for (int i = 0; i < p.length(); i ++){
            hash[p.charAt(i)] ++;
        }
    
        int left = 0;
        int right = 0;
        int count = p.length();
        List<Integer> list = new ArrayList<>();
	// iterate until right index == s.length()
        while(right < s.length()){
            if (hash[s.charAt(right)] >= 1){
                count --;
            }
            hash[s.charAt(right)] --;
            right ++;
            if (count == 0) {
                list.add(left);
            }
            //when the window size eqauls p
	    //every time when right ++, left needs to ++ as well 
            //
            if (right - left == p.length()){
                if (hash[s.charAt(left)] >= 0) {// hash[] >= 0, it means this char exists before.
                    count ++;    
                }
                hash[s.charAt(left)] ++;//restore the hash count
                left ++;              // left shift
            }
        }
        
        return list;
    }
}
