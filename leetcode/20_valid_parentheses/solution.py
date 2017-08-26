
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        """
        73 / 73 test cases passed.
        Status: Accepted
        Runtime: 38 ms
        79.17%
        stack
        """
        
        buffer = []
        half_parenthes = "({["
        parenthes = {"]":"[", 
                     ")":"(",
                     "}":"{"}
        if len(s) % 2:
            return False
            
            
        for char in s:
            if char in half_parenthes:
                buffer.append(char)
            else:
                if len(buffer) == 0:
                    return False
                if char in parenthes:
                    if buffer[-1] == parenthes[char]:
                        buffer.pop(-1)
                        continue
                    else:
                        return False
                    
        if len(buffer) == 0:
            return True
        else:
            return False
                
            

                
