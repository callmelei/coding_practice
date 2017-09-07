class Solution {
    public List<List<String>> groupAnagrams_sort(String[] strs) {
        /*hashmap + sort*/
        /*
        101 / 101 test cases passed.
        Status: Accepted
        Runtime: 22 ms
        98.06%
        Time: O(n^2)
        Space: O(n)
        */
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        List<List<String>> result = new ArrayList<>();
        int indexInBucket = 0;
        for (int i = 0; i < strs.length; i++) {
            char [] ch = strs[i].toCharArray();
            Arrays.sort(ch); //O(nlogn)
            String check = new String(ch);
            //System.out.print(check);
            if (hashmap.get(check) == null) {
                hashmap.put(check, indexInBucket);
                indexInBucket ++;
                List<String> strBucket= new ArrayList<String>();
                strBucket.add(strs[i]);
                result.add(strBucket);
            }else {
                int ix = hashmap.get(check);
                result.get(ix).add(strs[i]);
            }
            
        }
        
        return result;
        
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        /*hashmap + sort*/
        /*
        101 / 101 test cases passed.
        Status: Accepted
        Runtime: 25 ms
        89.40%
        Time: O(n^2)
        Space: O(n)
        use prime number to generate a key
        */
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        List<List<String>> result = new ArrayList<>();
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

        int indexInBucket = 0;
        for (int i = 0; i < strs.length; i++) {
            char [] ch = strs[i].toCharArray();
            int check = 1;
            for (int j = 0; j < ch.length; j++){
                check *= prime[ch[j]-'a'];   
            }
            //Arrays.sort(ch); //O(nlogn)
            //String check = new String(ch);
            //System.out.print(check);
            if (hashmap.get(check) == null) {
                hashmap.put(check, indexInBucket);
                indexInBucket ++;
                List<String> strBucket= new ArrayList<String>();
                strBucket.add(strs[i]);
                result.add(strBucket);
            }else {
                int ix = hashmap.get(check);
                result.get(ix).add(strs[i]);
            }
            
        }
        
        return result;
        
    }
}
