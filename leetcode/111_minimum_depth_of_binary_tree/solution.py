# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minDepth_bfs(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.myqueue = []
        self.min_level = 0
        #print "++++"
        if root == None:
            self.min_level = 0
        else:
            self.myqueue.append((root,1))
            while len(self.myqueue)>0:
                node = self.myqueue.pop(0)
                #print node[0].val
                if node[0].left != None:
                    self.myqueue.append((node[0].left,node[1]+1))
                if node[0].right != None:
                    self.myqueue.append((node[0].right,node[1]+1))
                if node[0].left == None and node[0].right == None:
                    self.min_level = node[1]
                    break
        return self.min_level
    def minDepth(self, root):
	"""
	41 / 41 test cases passed.
	Status: Accepted
	Runtime: 69 ms
	41.19%
	"""
        if root == None:
            return 0
        else:
            if root.right == None and root.left != None:
                return self.minDepth(root.left) + 1
            elif root.left == None and root.right != None:
                return self.minDepth(root.right) + 1
            else:
                return min(self.minDepth(root.left), self.minDepth(root.right))+1
