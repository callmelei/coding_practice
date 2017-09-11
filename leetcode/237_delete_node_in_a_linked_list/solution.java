
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        /*
        83 / 83 test cases passed.
Status: Accepted
Runtime: 1 ms
3.73%
*/
        if (node == null) 
            return;
        ListNode  curr;
        curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            if (next != null) {
                curr.val = next.val;
            }
            if (curr.next.next == null)
                curr.next = null;
            curr = curr.next;
        }        
    }
}
