///Most recommended approach - Inorder Traversal
//Time complexity -  O(N)
//Space Complexity -  O(N)  - due to stack (recursion)


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ValidateBST {

    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (!inorderTraversal(node.left)) {
            return false;
        }

        if (prev != null && prev.val >= node.val) {
            return false;
        }

        prev = node;

        return inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        ValidateBST validator = new ValidateBST();

        // Example usage:
        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(3);

        // System.out.println(validator.isValidBST(root));
    }
}
