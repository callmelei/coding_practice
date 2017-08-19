class Solution(object):
    def reverse_enum(self, L):
        for index in reversed(xrange(len(L))):
            yield index, L[index]
    def plusOne_yield(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
	"""
	108 / 108 test cases passed.
	Status: Accepted
	Runtime: 52 ms
	9.64%
	"""
        n = len(digits)
        carry = 1
        for ix, digit in self.reverse_enum(digits):
            #print ix, digit
            sum_digit = digit + carry
            if sum_digit > 9:
                carry = 1
            else:
                carry = 0
            digits[ix] = sum_digit % 10
        if carry == 1:
            digits.insert(0, 1)
        return digits
def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
	"""
	108 / 108 test cases passed.
	Status: Accepted
	Runtime: 66 ms	
	1.98%
	"""
        """
        Q. Is this a number larger than 32bit?
        A. yes, according to the description, it seems it is a big number
        Q. Do we have empty list?
        A. No, it's a non-empty array
        Q. Do we have negative number array?
        A. No, it's a non-nagtive number array.
        Q. Do we have 0 leading number?
        A. No, we do not have 0 leading number.
        Q. Should we reverse the output
        A. No, the output cannot be reversed
        """
        """
        algorithim
        1. add each digit and carry one by one from the end
        2. check the sum of addition is larger than 9
        3. if true, set carry = 1
        4. in the end, must chck the carry is 1 or 0, and do the insertion
        """
        n = len(digits)
        carry = 1
        for ix in reversed(xrange(len(digits))):
            #print ix, digit
            digit = digits[ix]
            sum_digit = digit + carry
            if sum_digit > 9:
                carry = 1
            else:
                carry = 0
            digits[ix] = sum_digit % 10
        if carry == 1:
            digits.insert(0, 1)
        return digits
