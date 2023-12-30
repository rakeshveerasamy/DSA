//Inorder traversal - Morris Traversal Implementation
//Time complexity - O(n) - worst case every node will vists twice
//space complexity - O(1) 


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
	 if(root ==  null) {
            return;
        }
        TreeNode curr = root;
        while(curr!=null) {
            if(firstElement==null && prev.val>curr.val) {
                firstElement = prev;
            }
            if(firstElement!=null && prev.val>curr.val){
                secondElement = curr;
            }
            if(curr.left == null) {
                System.out.println(curr.val);
                prev =  curr;
                curr = curr.right;
            }
            else {
                TreeNode temp =  curr.left;
                while(temp.right!=null && temp.right!=curr) {
                    temp = temp.right;
                }
                if(temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                else if (temp.right == curr) {
                    temp.right = null;
                    prev =  curr;
                    System.out.println(curr.val);
                    curr = curr.right;
                }
            }
        }
}

}
