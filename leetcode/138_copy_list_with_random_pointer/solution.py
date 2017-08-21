# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
	"""
	1. Create a new node and put it in the end of the original one
	   0->0'->1->1'->2->2'->3->3'
	2. Connect the random node

	3. Separate the original list and duplicated list


	Time complexity = O(n), space complexity = O(1)
	12 / 12 test cases passed.
	Status: Accepted
	Runtime: 139 ms
	44.33%
	"""
        curr = head
        while curr != None:
            node = RandomListNode(curr.label)
            node.next = curr.next
            curr.next = node
            curr = node.next
        
        curr = head
        while curr != None:
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
            
        dummy = RandomListNode(-1)
        newHead = dummy
        curr = head     
        while curr != None:
            dummy.next = curr.next
            dummy = dummy.next
            curr.next = curr.next.next
            curr = curr.next
        
        return newHead.next
        
