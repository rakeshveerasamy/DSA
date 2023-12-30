// recursive Inorder traversal
//Time complexity =  O(n)
//Space complexity = O(n)  = due to stack ( recursion)

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
    private TreeNode firstElement;
	private TreeNode secondElement;
	private TreeNode prev;
    public void recoverTree(TreeNode root) {
        firstElement  =  null;
	secondElement =  null;
	 prev = null;
      prev =   new TreeNode(Integer.MIN_VALUE);

	InorderTraversal(root);
	
	int temp  =  firstElement.val;
	firstElement.val   =  secondElement.val;
	secondElement.val  =  temp;
    }

	
private void  InorderTraversal(TreeNode root) {
	if(root ==null) return ;
	InorderTraversal(root.left);
	if(firstElement==null && prev.val>root.val) firstElement = prev;
	if(firstElement!=null && prev.val>root.val) secondElement =  root;
    prev =root;
    InorderTraversal(root.right);
}

}
