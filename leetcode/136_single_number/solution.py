class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        """
        15 / 15 test cases passed.
        Status: Accepted
        Runtime: 58 ms
        22.30%
        """
        a = 0
        for i in range(len(A)):
            a ^= A[i]
        return a
