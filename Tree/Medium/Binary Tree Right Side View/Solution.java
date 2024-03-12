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
    public List<Integer> rightSideView(TreeNode root) {
        TreeSideView tsv =  new TreeSideView(root);
        return tsv.getRightSideView();
    }
}
class TreeSideView{
	private TreeNode root;
	TreeSideView(TreeNode root){
		this.root = root;
	}
	public List<Integer> getRightSideView(){
		List<Integer> res =  new ArrayList<>();
		if(this.root == null) return res;
		Queue<TreeNode> queue= new LinkedList<>();
		queue.offer(this.root);
		while(!queue.isEmpty()) {
			int len = queue.size();
			for(int i=0;i<len;i++) {
				TreeNode temp = queue.poll();

				if(i == len-1) {
					res.add(temp.val);
				}
				if(temp.left!=null) {
					queue.offer(temp.left);
				}
				if(temp.right!=null) {
					queue.offer(temp.right);
				}
			}
		}
		return res;
	}
}
