

        
class Solution(object):
    def singleNumber_bitcount(self, nums):
	"""
11 / 11 test cases passed.
Status: Accepted
Runtime: 102 ms
14.39%
	"""
	    ret = 0
	    for i in range(32):
		    sum = 0
		    for num in nums:
			    sum = sum + ((num>>i) & 0x1)
		    sum = sum % 3
		    ret = ret | (sum << i)
	    return self.toSigned32(ret)
    def toSigned32(self, n): 
        n = n & 0xffffffff
        return (n ^ 0x80000000) - 0x80000000
    def singleNumber(self, nums):
        """
        11 / 11 test cases passed.
        Status: Accepted
        Runtime: 56 ms
        34.91%
        """
        one = 0
        two = 0
        three = 0
        for num in nums:
            two |= (one & num)
            one ^= num
            three = (one & two)
            one &= ~three
            two &= ~three
        return one
