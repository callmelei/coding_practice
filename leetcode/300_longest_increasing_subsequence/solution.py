class Solution(object):
    def lengthOfLIS(self, nums):
        """
        24 / 24 test cases passed.
Status: Accepted
Runtime: 1232 ms
29.64%
        """
        dp = [0 for x in range(len(nums))]
        max_length = float("-inf")
        
        if len(nums) == 0:
            return 0
        
        for x in range(len(nums)):
            max_value = dp[x]
            for y in reversed(range(x)):
                if nums[x] > nums[y]:
                    max_value = max(dp[y], max_value)

            dp[x] = max_value + 1
            max_length = max(dp[x], max_length)
        return max_length
