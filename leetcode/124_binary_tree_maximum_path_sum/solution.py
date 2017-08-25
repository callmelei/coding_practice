# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxPathSum(self, root):
	"""
	92 / 92 test cases passed.
	Status: Accepted
	Runtime: 158 ms
	50.09%
        time complexity:O(n)
        space complexity:O(1)
	"""
        
        self.maxVal = float('-inf')
        
        self.helper(root)
        
        #print self.maxVal
        
        return self.maxVal
    
    def helper(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        else:
            left = self.helper(root.left)
            right = self.helper(root.right)
            self.maxVal = max(left + right + root.val, self.maxVal) #record the maximum value between current value and the sum of this node
            ret = max(left,right) + root.val #choose one max path between left and right
            if (ret) < 0: # don't return 0, it can simplify the calculations
                return 0
            else:
                return ret
            
        
