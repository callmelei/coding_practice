
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode_hash(ListNode headA, ListNode headB) {
        /*hash table: 
        time: O(m+n)
        space: O(n) or O(m)
        42 / 42 test cases passed.
Status: Accepted
Runtime: 16 ms
4.6%
        */
        HashMap <ListNode, Integer> hash = new HashMap<ListNode, Integer>();
        
        ListNode curr = headA;
        while (curr != null) {
            hash.put(curr, 1);
            curr = curr.next;
        }
        curr = headB;
        while(curr != null) {
            if (hash.get(curr) != null){
                return curr;
            } else {
                curr = curr.next;
            }
            
        }
        return null;
    }
    public ListNode getIntersectionNode_bad(ListNode headA, ListNode headB) {
    /*
    two points:
    time :O(m+n)
    space: O(1)
    just like finding the cycle of a linked list.
    42 / 42 test cases passed.
Status: Accepted
Runtime: 5 ms
10%
    */
        int stateA = 0;
        int stateB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        if (currA == null || currB == null) 
            return null;
        while (true) {
            if (true) {
                
                if (stateA == 0 && currA == null) {
                    currA = headB;
                    stateA ++;
                }
                if (stateB == 0 && currB == null) {
                    currB = headA;
                    stateB ++;
                }
                
                if (stateA == 1 && currA == null)
                    break;
                if (stateB == 1 && currB == null)
                    break;
                
                if (currA.val == currB.val)
                    return currA;
                
                if (stateA <= 1) {
                    //System.out.println(currA.val);
                    currA = currA.next;
                }
                if (stateB <= 1) {
                    //System.out.println(currB.val);
                    currB = currB.next;
                }
                
                
            }
        }
        return null;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
        42 / 42 test cases passed.
Status: Accepted
Runtime: 3 ms
13.99%
        */
        ListNode currA = headA;
        ListNode currB = headB; 
        int count = 0;
        if (currA == null || currB == null)
            return null;
        while (true) {
            if (currA == null) {
                currA = headB;
                count ++;
            }
            
            if (currB == null) {
                currB = headA;
            }
            
            if (currA != null && currB != null && currA.val == currB.val)
                break;
            
            if (count == 2) {
                return null;
            }
            currA = currA.next;
            currB = currB.next;
                
        }
        return currA;
    
    }
}
