
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
from Queue import PriorityQueue
class Solution(object):
    def mergeKLists_heap_priority_queue(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        """
        review a short tutorial video: 
        heap and priority queue https://www.youtube.com/watch?v=hj9lOSJCy-U
        this problem can be solved by priority queue
        since priority queues normal are implemented by heap tree.
        the insertion and removal of heap tree is O(logn)
        there are nk elements
        therefore we got O(nklogn) time complexity and O(k) space complexity
        """
        """
        130 / 130 test cases passed.
        Status: Accepted
        Runtime: 219 ms
        29.71%
        """
        q = PriorityQueue()
        for list in lists:
            if list != None:
                q.put((list.val, list)) # push a tupe
        head = ListNode(0)
        curr = head
        while q.qsize() > 0:
            tmp = q.get()[1]
            curr.next = tmp
            curr = curr.next
            if tmp.next != None:
                q.put((tmp.next.val, tmp.next))
        return head.next
    def mergeKLists(self, lists):
        """
        divide and conquer method
        the time complexity is O(nklogk), space complexity is O(1)
        
        k*n + k/2*2n + k/4*4n + ... +
        = nk * logk
           
        130 / 130 test cases passed.
        Status: Accepted
        Runtime: 135 ms
        70.44%
        
        """
        tmp_list = []
        if len(lists) == 0:
            return []
        while len(lists) > 1:
            while len(lists) > 0:
                if len(lists) >= 2:
                    l1 = lists.pop()
                    l2 = lists.pop()
                    l3 = self.mergeTwoLists(l1,l2)
                    tmp_list.append(l3)
                elif len(lists) == 1:
                    tmp_list.append(lists.pop())
            for node in tmp_list:
                lists.append(node)
            tmp_list = []
        return lists[0]
            

    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
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

