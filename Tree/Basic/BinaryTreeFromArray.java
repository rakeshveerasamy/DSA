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
private TreeNode constructBinaryTree(int [] arr) {
	return constructBinaryTree(arr,0);
}
private TreeNode constructBinaryTree(int [] arr, int index) {
TreeNode curr =  new TreeNode(arr[index]);
int size = arr.length;

int left = 2*index+1;
int right = 2*index+2;

if(left<size) 	{
 	curr.left= constructBinaryTree(arr,left);
}
if(right<size) {
curr.right = constructBinaryTree(arr,right);
}
return curr;
}
private void printTreeInOrder(TreeNode root) {
	if(root == null) {
		return;
            }
            printTreeInOrder(root.left);
	System.out.print(root.val+ “   “);
	printTreeInOrder(root.right);
}
public static void main (String [] args) throws Exception {
int [] arr =  new int [] {1,2,3,4,5,6,7,8,9};
Tree tree =  new Tree();
TreeNode root = tree.constructBinaryTree(arr);	
tree.printTreeInOrder(root);
}
	
}
