//TIme complexity = o(n)
//Space complexity = O(n)


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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        return inOrderTraversal(root,hashSet,k);
    }
    private boolean inOrderTraversal(TreeNode root, HashSet<Integer>hashSet , int k){
        if(root == null){
            return false;
        }
        if(hashSet.contains(k-root.val)){
            return true;
        }
        hashSet.add(root.val);
        return inOrderTraversal(root.left,hashSet,k) || inOrderTraversal(root.right,hashSet,k);
    }
}
