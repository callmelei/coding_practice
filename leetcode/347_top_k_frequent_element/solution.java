

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
        tag: bucket sort, hash, frequency
        when counting the frequency, we can consider bucket sort
        when using bucket sort: like the reverse map
        1. use hashmap to count the frequecy of each pattern
        key: pattern
        value: frequeny
        2. use bucket list to store the frequency and the pattern
        
        Since there is no need to run sort under bucket sort,
        the time complexity will be O(n), but the space complexity will be high
        
        time: O(n)
        space: O(n)
20 / 20 test cases passed.
Status: Accepted
Runtime: 29 ms
58.90%
        */
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();
    
        
        for (int num: nums) {
            if (freqMap.get(num) == null)
                freqMap.put(num,1);
            else
                freqMap.put(num, freqMap.get(num)+1);
        }
        
        List<Integer>[] bucket = new List[nums.length+1];
        for (int key: freqMap.keySet()) {
            int value = freqMap.get(key);
            if (bucket[value] == null)
                bucket[value] = new LinkedList<Integer>();
            bucket[value].add(key);
        }
        
        List<Integer> ans = new LinkedList<Integer>();
        for (int i = bucket.length-1; i >= 0 && ans.size() < k; i--) {
            if (bucket[i] != null)
                ans.addAll(bucket[i]);
        }
        
        return ans;
    }
    /*
    "       Comparator<String> comp = new Comparator<String> (){
            public int compare(String s1, String s2) {
               // @Override
                String str1 = s1+s2;
                String str2 = s2+s1;
                
                return str2.compareTo(str1);
            }
            
        };
        
        Arrays.sort(str_num, comp);"
    */
}
