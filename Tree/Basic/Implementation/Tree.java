public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data) {
		this.val =  data;
		this.left = null;
		this.right = null;
	}
	public TreeNode (int data, TreeNode left, TreeNode right) {
		this.val = data;
		this.left =  left;
		this.right =  right;
	}
}
public class Tree {
TreeNode root;
public Tree() {
this.root = null;
}
	
}
