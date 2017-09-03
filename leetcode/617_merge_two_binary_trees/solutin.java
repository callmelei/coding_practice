
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        /*183 / 183 test cases passed.
Status: Accepted
Runtime: 14 ms
76.0%
*/
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null && t2 != null) {
            return t2;
        } else if (t2 == null && t1 != null) {
            return t1;
        } else {
            TreeNode node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
            return node; 
        }
    }
}
