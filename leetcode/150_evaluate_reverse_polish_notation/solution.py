
class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
	"""
	20 / 20 test cases passed.
Status: Accepted
Runtime: 116 ms
	11.30
	"""
        result = 0
        operand = ["+","-","*","/"]
        
        if len(tokens) == 0:
            return result
        
        calculation = []
        while len(tokens) > 0:
            token = tokens.pop(0)
            if token in operand:
                argu2 = int(calculation.pop())
                argu1 = int(calculation.pop())
                if(token == "+"):
                        result = argu1+argu2
                        
                elif(token == "-"):
                        result = argu1-argu2
                        
                elif(token == "*"):
                        result = argu1*argu2
                        
                elif(token == "/"):
                        result = int(float(argu1)/argu2)
                        
                        
                #print argu1, token, argu2, result
                        
                calculation.append(str(result))
            else:
                calculation.append(token)
        
        return int(calculation[0])
            
