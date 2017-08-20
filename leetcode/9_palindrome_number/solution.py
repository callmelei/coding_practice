class Solution(object):
    def isPalindrome(self, x):
        """
        11507 / 11507 test cases passed.
        Status: Accepted
        Runtime: 212 ms
        71.72%
        """
        """
        :type x: int
        :rtype: bool
        """
        """
        Q. Do we have negative number?
        A. maybe, and it's not a palindrome number
        Q. Do we have hexadecimal number?
        A. No
        Q. How to solve it without extra memory?
        A.
        
        Problem of reverse method: 
        when reverse the numbers, it may occur the overflow problem.
        the value will be zero, how to fix this problem?
        this problem depends on different language, it may not happen in Python
        
        1. Count the digits by dividing 10 looply
        2. Compare the digits between start and end
        """
        if x < 0:
            return False
        backup = x
        reversed_val = 0
        while backup !=0:
            reversed_val = (backup % 10) + (reversed_val * 10)
            backup /= 10
        #print reversed_val
        if reversed_val == x:
            return True
        else:
            return False
    def isPalindrome_compare2ends(self, x):
        """
        compare two ends
        11507 / 11507 test cases passed.
        Status: Accepted
        Runtime: 236 ms
        45.14%
        """
        if x < 0:
            return False
        div = 10
        while (x/div > 0):
            div = div * 10
        div = div / 10
        while x > 0:
            l = int(x / div)
            r = int(x % 10)
            if l != r:
                return False
            else:
                x = x - l * div # remove leftmost 1 digit
                x = x / 10 #remove rightmost 1 digit
                div = div / 100
        return True
                
