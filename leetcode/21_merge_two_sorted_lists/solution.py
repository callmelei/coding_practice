# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
	"""
	208 / 208 test cases passed.
	Status: Accepted
	Runtime: 45 ms
	83.47
	"""
        curr_L1 = l1
        curr_L2 = l2
        l3 = ListNode(0)
        curr_L3 = l3
 
        if not l1 or not l2:
            return l1 or l2
        while curr_L1 != None or curr_L2 != None:
            if curr_L1 == None:
               curr_L3.next = curr_L2
               break
            if curr_L2 == None:
               curr_L3.next = curr_L1
               break
           
            if curr_L1.val < curr_L2.val:
                curr_L3.next = curr_L1
                curr_L1 = curr_L1.next
            else:
                curr_L3.next = curr_L2
                curr_L2 = curr_L2.next
                
            curr_L3 = curr_L3.next
            #print curr_L3.val
        return l3.next
        
