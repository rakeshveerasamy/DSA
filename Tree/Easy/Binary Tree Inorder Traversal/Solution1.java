//Time Complexity - O(n) and space complexity - O(n) - due to recursion

class Solution {
    List<Integer> inorderList = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            inorderList.add(root.val);
            inorderTraversal(root.right);
        }
        return inorderList;
    }
}
