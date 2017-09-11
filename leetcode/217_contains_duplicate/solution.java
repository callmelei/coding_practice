/*
 *For certain test cases with not very large nn, the runtime of this method can be slower than Approach #2. The reason is hash table has some overhead in maintaining its property. One should keep in mind that real world performance can be different from what the Big-O notation says. The Big-O notation only tells us that for sufficiently large input, one will be faster than the other. Therefore, when n is not sufficiently large, an O(n) algorithm can be slower than an O(nlogn) algorithm.
 * */
class Solution {
    public boolean containsDuplicate_hashmap(int[] nums) {
        /*
        use hashmap
        time: O(n)
        space: O(n)
        
        18 / 18 test cases passed.
Status: Accepted
Runtime: 21 ms
29.92%
        */
        
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int num: nums) {
            if (hash.get(num) == null)
                hash.put(num, 1);
            else 
                return true;            
        }
        
        return false;
        
    }
    public boolean containsDuplicate_sort(int[] nums) {
        /*
        use sort
        time: O(nlogn)
        space: O(1)
        18 / 18 test cases passed.
Status: Accepted
Runtime: 7 ms
84.48%
        */
        
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i-1])
                return true;
        }
        
        return false;
        
    }
    
    public boolean containsDuplicate(int[] nums) {
        /*
      
      user hashset
      time:O(n)
      space:O(n)
        18 / 18 test cases passed.
Status: Accepted
Runtime: 14 ms
68.96%
        */
	HashSet<Integer> set = new HashSet<Integer>();
	for(int i=0;i<nums.length;i++){
		if(!set.add(nums[i])) return true;
	}
	return false;
}
}
