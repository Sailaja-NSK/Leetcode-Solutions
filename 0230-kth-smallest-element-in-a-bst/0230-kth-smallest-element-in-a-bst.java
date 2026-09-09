/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inOrderTraversal(TreeNode root,List<Integer> inOrder) {
        if(root == null) return;

        inOrderTraversal(root.left,inOrder);
        inOrder.add(root.val);
        inOrderTraversal(root.right,inOrder);

    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root,inOrder);
        return inOrder.get(k-1);
    }
}