class Solution:
    # @return an integer
    def reverse(self, x):
        """
        1032 / 1032 test cases passed.
        Status: Accepted
        Runtime: 48 ms
        76.46%
        """
        out = 0
        negative = 0
        if (x < 0):
            x = 0 - x
            negative = 1

        while(x):
            tmp = x % 10
            out = out * 10 + tmp
            x = x / 10
        if (negative == 1):
            out = 0 - out
	"""
	take care of the overflow cases
	e.g.
	positive value > 0x7FFFFFFF(2147483647)
	negative value < -0x7FFFFFFF(-2147483647)
	"""
        if out > 0x7FFFFFFF  or out < -0x7FFFFFFF:
                return 0
        return out
