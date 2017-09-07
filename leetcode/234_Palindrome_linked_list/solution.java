
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome_stack(ListNode head) {
        /*
        stack
        time: O(n)
        space: O(n)
        26 / 26 test cases passed.
Status: Accepted
Runtime: 8 ms
4.32%
        */
        Stack<Integer> stack = new Stack<>();  
        ListNode curr = head;
        int temp = 0;
        
        if (curr == null) 
            return true;
        
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        
        curr = head;
        while (!stack.isEmpty() && curr != null) {
            temp = stack.pop();
            if (temp != curr.val)
                break;
            curr = curr.next;
        }
        
        if (stack.isEmpty() && curr == null) {
            return true;
        } else {
            return false;
        }
        
    }
    
    public boolean isPalindrome(ListNode head) {
    /*two point: slow and fast
    1. find the middle point: set fast is twice speed as slow.
    when fast arrive end, slow is in the middle.
    2. reverse right half
    3. compare head and right
    */
        
        /*
        time: O(n)
        space: O(1)
        26 / 26 test cases passed.
Status: Accepted
Runtime: 2 ms
33.61%
        */
    
        ListNode fast, slow, prev, next;
        
        if (head == null)
            return true;
        
        fast = slow = head;
        /*handle even nodes*/
        //1->2->3->4->5->6->null
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // not must
        ///*handle odd nodes*/
        ////1->2->3->4->5->null
        //if (fast != null)
        //    slow = slow.next;
        
        /*reverse linked list*/
        prev = null;
        
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        slow = prev;
        fast = head;
        
        while (slow != null) {
            if (fast.val != slow.val)
                return false;
                
            fast = fast.next;
            slow = slow.next;            
        }
    
        return true;
    }

}
