
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers_test(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        ret = ListNode(0)
        cur = ret
        add = 0
        
        while l1 or l2 or add:
            val = (l1.val if l1 else 0) + (l2.val if l2 else 0) + add
            add = val / 10
            cur.next = ListNode(val % 10)
            cur = cur.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        
        return ret.next
    
    
    def addTwoNumbers(self, l1, l2):
        """
        1562 / 1562 test cases passed.
    Status: Accepted
    Runtime: 129 ms
        51.96%
        """
        l3 = ListNode(0)
        curr_l3 = l3
        curr_l1 = l1
        curr_l2 = l2
        carry = 0
        while curr_l1 or curr_l2 :
            if curr_l1 == None:
                sumDigit = carry + curr_l2.val
                curr_l2 = curr_l2.next
            elif curr_l2 == None:
                sumDigit = carry + curr_l1.val
                curr_l1 = curr_l1.next
            else:
                sumDigit = curr_l1.val + curr_l2.val + carry
                curr_l1 = curr_l1.next
                curr_l2 = curr_l2.next
                
            if sumDigit > 9:
                sumDigit = sumDigit % 10
                carry = 1
            else:
                carry = 0
                
            tmp = ListNode(sumDigit)
            curr_l3.next = tmp
            curr_l3 = curr_l3.next
            #print sumDigit, curr_l3.val
        if carry > 0:
            tmp = ListNode(carry)
            curr_l3.next = tmp
            curr_l3 = curr_l3.next           
        return l3.next
