
class Solution:
    # @param root, a tree node
    # @return an integer
    def maxDepth(self, root):
	"""
	38 / 38 test cases passed.
	Status: Accepted
	Runtime: 52 ms
	85.15%
	"""
        if root == None: return 0
        else:
            max_depth = max(self.maxDepth(root.left), self.maxDepth(root.right))+1
        return max_depth

