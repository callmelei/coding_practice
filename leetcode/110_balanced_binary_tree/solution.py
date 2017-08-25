# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
	"""
	it's a bottom-up stack solution.
	time complexity: O(n)
	space complexity: O(n)
	226 / 226 test cases passed.
	Status: Accepted
	Runtime: 69 ms
	79.99%
	"""
        result = self.get_depth(root, 0)
        
        if result == -1:
            return False
        else:
            return True
            
    def get_depth(self, root, depth):

        if root == None:
            return 0
        else:
            left = self.get_depth(root.left, depth+1)
            if left == -1: return -1 #early stop sign
            right = self.get_depth(root.right, depth+1)
            if right == -1: return -1

            if abs(left-right) >= 2:
                return -1
            else:
                return max(left, right)+1

