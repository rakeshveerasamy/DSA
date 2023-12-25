//Time Complexity - O(n) n- number of nodes
//space complexity - O(m) - m - maximum number of node in any level of tree


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder  = new LinkedList<>();
        if(root == null) return levelOrder;
        return levelOrder(root,levelOrder);
    }
    public  List<List<Integer>> levelOrder(TreeNode root, List<List<Integer>> levelOrder) {
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode temp = null;
        if(root!=null){
            que.add(root);
        }
        while(!que.isEmpty()){
            int size =que.size();
            List<Integer> list = new LinkedList<>();
            while(size>0){
                temp = que.remove();
                list.add(temp.val);
                if(temp.left!=null){
                    que.add(temp.left);
                }
                if(temp.right!=null){
                    que.add(temp.right);
                }
                size--;
            }    
            levelOrder.add(list);
        }
        return levelOrder;
    }
}
