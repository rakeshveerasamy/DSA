//Inorder Traversal


import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val){
        this.val =  val;
        this.left =  null;
        this.right = null;
    }
    TreeNode (int val, TreeNode left , TreeNode right) {
        this.val =  val;
        this.right =  right;
        this.left = left;
    }
}
public class Main {

    public static void InorderMorrisTraversal(TreeNode root) {
        if(root ==  null) {
            return;
        }
        TreeNode curr = root;
        while(curr!=null) {
            if(curr.left == null) {
                System.out.println(curr.val);
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
                    System.out.println(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
    public static void main (String [] args) throws Exception {
        TreeNode root =  new TreeNode(9);
        root.left = new TreeNode(5);
        root.left.left =  new TreeNode(3);
        root.left.left.left =  new TreeNode(1);
        root.left.left.right =  new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);

        root.right =  new TreeNode(12);
        root.right.left =  new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.right.right.right =  new TreeNode(15);

        InorderMorrisTraversal(root);
    }

}


