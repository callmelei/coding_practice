# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        """
        55 / 55 test cases passed.
        Status: Accepted
        Runtime: 29 ms
        99%
        Q. Is it a even number pairs?
        A. no mention in the description, we can get the answer by input this case, leave the odd element
        Q. Do we have empty list?
        A. just return empty list
        """


        if head == None:
            return None
        if head.next == None:
            return head
        newhead_node = ListNode(0)
        curr_node = head
        newhead_node.next = head.next
        pre_node = ListNode(0)
        pre_node.next = newhead_node
        while curr_node and curr_node.next != None:
            next_node = curr_node.next
            pre_node.next = next_node
            tmp = curr_node
            curr_node.next = next_node.next
            next_node.next = tmp
            #curr_node.next, next_node.next = next_node.next, curr_node.next
            #print curr_node.val, next_node.val
            pre_node = curr_node
            curr_node = curr_node.next
        return newhead_node.next
