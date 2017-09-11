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
    List<Integer> nums = new ArrayList<Integer>();
    int min = Integer.MAX_VALUE;
    TreeNode prev = null, curr = null;
    public int getMinimumDifference(TreeNode root) {
        /*
        Q. what if the numbers of this node is less than 2. (0,1)
        A. no mention
        Q. what if the float value?
        A. no mention

        */
       
        //BST_list(root);
        BST(root);

        return min;
        
    }
    public void BST_list(TreeNode node) {
         /*
        186 / 186 test cases passed.
        Status: Accepted
Runtime: 17 ms
41.20%
        */
        if (node == null) return;
        else {
            BST_list(node.left);
            nums.add(node.val);
            if (nums.size() >= 2)
                min = Math.min(min, Math.abs(nums.get(nums.size()-1)-nums.get(nums.size()-1-1)));
            BST_list(node.right);
        }
        return;
    }
    public void BST(TreeNode node) {
        /*
        186 / 186 test cases passed.
Status: Accepted
Runtime: 17 ms
41.20%
        */
        if (node == null) return;
        else {
            BST(node.left);
            prev = curr;
            curr = node;
            if (prev != null)
                min = Math.min(min, Math.abs(curr.val - prev.val));
            BST(node.right);
        }
        return;
    }
}
