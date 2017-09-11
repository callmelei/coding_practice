class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
        use hashmap
        23 / 23 test cases passed.
Status: Accepted
Runtime: 21 ms
        20%
        */
        
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            
            if (hash.get(nums[i]) == null)
                hash.put(nums[i], i);
            else {
                if (i - hash.get(nums[i]) <= k)
                    return true;
                else
                    hash.put(nums[i], i);
                
            }
        }
        return false;
    }
}
