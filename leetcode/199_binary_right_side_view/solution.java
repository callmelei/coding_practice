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
    public List<Integer> rightSideView(TreeNode root) {
        /*
        210 / 210 test cases passed.
	Status: Accepted
	Runtime: 2 ms
	25.14%
	BFS
        */
        
        List<Integer> ans = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) return ans;
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size(); /*it's the key, it can maintain the level of tree*/
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (i == size-1)
                    ans.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
        }
        
        return ans;
        
    }
}
