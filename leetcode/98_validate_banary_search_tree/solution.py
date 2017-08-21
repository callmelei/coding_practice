
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
	"""
	tow-down recursion:
	left value is less than root value and larger than previous lowest value
	right value is larger than root value and lower than previous largest value

	Since we need to handle the integer.max and value integer.min.
	We cannot put integer.max and integer.min in the initial function.
	Instead, we put None in the initial function.
	
	Time complexity: O(n), space complexity: O(1)

        74 / 74 test cases passed.
        Status: Accepted
        Runtime: 69 ms
        57.23%
	"""
        return self.isValid(root, None, None)
    def isValid(self, root, low, high):
        if root == None:
            return True
        elif (low == None or root.val > low) and (high == None or root.val < high):
            ret_left = self.isValid(root.left, low, root.val)
            ret_right = self.isValid(root.right, root.val, high)
            return ret_left and ret_right
        else:
            return False
